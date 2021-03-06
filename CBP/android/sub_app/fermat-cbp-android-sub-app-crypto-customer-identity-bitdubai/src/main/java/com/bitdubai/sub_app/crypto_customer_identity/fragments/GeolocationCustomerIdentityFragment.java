package com.bitdubai.sub_app.crypto_customer_identity.fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bitdubai.fermat_android_api.layer.definition.wallet.AbstractFermatFragment;
import com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.ReferenceAppFermatSession;
import com.bitdubai.fermat_api.layer.all_definition.common.system.interfaces.error_manager.enums.UnexpectedSubAppExceptionSeverity;
import com.bitdubai.fermat_api.layer.all_definition.common.system.interfaces.error_manager.enums.UnexpectedUIExceptionSeverity;
import com.bitdubai.fermat_api.layer.all_definition.enums.GeoFrequency;
import com.bitdubai.fermat_api.layer.all_definition.enums.UISource;
import com.bitdubai.fermat_api.layer.all_definition.exceptions.InvalidParameterException;
import com.bitdubai.fermat_api.layer.dmp_engine.sub_app_runtime.enums.SubApps;
import com.bitdubai.fermat_cbp_api.layer.identity.crypto_customer.exceptions.CantGetCryptoCustomerIdentityException;
import com.bitdubai.fermat_cbp_api.layer.sub_app_module.crypto_customer_identity.interfaces.CryptoCustomerIdentityInformation;
import com.bitdubai.fermat_cbp_api.layer.sub_app_module.crypto_customer_identity.interfaces.CryptoCustomerIdentityModuleManager;
import com.bitdubai.fermat_pip_api.layer.network_service.subapp_resources.SubAppResourcesProviderManager;
import com.bitdubai.sub_app.crypto_customer_identity.R;
import com.bitdubai.sub_app.crypto_customer_identity.util.FragmentsCommons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * FERMAT-ORG
 * Developed by Lozadaa on 04/04/16.
 * Updated by Jose Cardozo josejcb (josejcb89@gmail.com) on 16/06/16.
 */

public class GeolocationCustomerIdentityFragment
        extends AbstractFermatFragment<ReferenceAppFermatSession<CryptoCustomerIdentityModuleManager>, SubAppResourcesProviderManager> {

    EditText accuracy;
    Spinner frequency;
    Toolbar toolbar;
    int accuracyData;
    GeoFrequency frequencyData;


    public static GeolocationCustomerIdentityFragment newInstance() {
        return new GeolocationCustomerIdentityFragment();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = getToolbar();
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.go_back_button));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootLayout = inflater.inflate(R.layout.fragment_cbp_identity_geolocation_v2, container, false);
        initViews(rootLayout);

        configureToolbar();

        return rootLayout;
    }

    @SuppressWarnings("deprecation")
    private void configureToolbar() {
        Toolbar toolbar = getToolbar();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            toolbar.setBackground(getResources().getDrawable(R.drawable.cci_action_bar_gradient_colors_v2, null));
        else
            toolbar.setBackground(getResources().getDrawable(R.drawable.cci_action_bar_gradient_colors_v2));
    }

    private void initViews(View layout) {
        // Spinner Drop down elements
        List<GeoFrequency> dataSpinner = new ArrayList<>();
        dataSpinner.addAll(Arrays.asList(GeoFrequency.values()));

        // Spinner element
        accuracy = (EditText) layout.findViewById(R.id.accuracy);
        frequency = (Spinner) layout.findViewById(R.id.spinner_frequency);
        frequency.setBackgroundColor(Color.parseColor("#f9f9f9"));

        try {
            ArrayAdapter<GeoFrequency> dataAdapter = new ArrayAdapter<>(getActivity(), R.layout.cbp_iden_spinner_item, dataSpinner);
            dataAdapter.setDropDownViewResource(R.layout.cbp_iden_spinner_item);
            frequency.setAdapter(dataAdapter);

            setValues(frequency, accuracy, dataAdapter);

            frequency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    try {
//                        frequencyData = GeoFrequency.getByCode(parent.getItemAtPosition(position).toString());
                        frequencyData = (GeoFrequency) parent.getItemAtPosition(position);
                        frequencyData = GeoFrequency.getByCode(frequencyData.getCode());
                        ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#616161"));
                        (parent.getChildAt(0)).setBackgroundColor(Color.parseColor("#F9f9f9"));
                    } catch (InvalidParameterException ex) {
                        appSession.getErrorManager().reportUnexpectedUIException(UISource.VIEW,
                                UnexpectedUIExceptionSeverity.UNSTABLE, ex);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        } catch (CantGetCryptoCustomerIdentityException ex) {
            appSession.getErrorManager().reportUnexpectedSubAppException(SubApps.CBP_CRYPTO_CUSTOMER_IDENTITY,
                    UnexpectedSubAppExceptionSeverity.DISABLES_SOME_FUNCTIONALITY_WITHIN_THIS_FRAGMENT, ex);
        }

    }

    @Override
    public void onBackPressed() {
        saveIdentityGeolocation();
    }

    private void saveIdentityGeolocation() {
        if (accuracy.getText().length() == 0) {
            Toast.makeText(getActivity(), R.string.crypto_customer_empty_accuracy, Toast.LENGTH_SHORT).show();
        } else {
            accuracyData = Integer.parseInt(accuracy.getText().toString());

            appSession.setData(FragmentsCommons.FREQUENCY_DATA, frequencyData);
            appSession.setData(FragmentsCommons.ACCURACY_DATA, accuracyData);
        }
    }

    private void setValues(Spinner frequency, EditText accuracy, ArrayAdapter<GeoFrequency> dataAdapter) throws CantGetCryptoCustomerIdentityException {
        final CryptoCustomerIdentityInformation identityInfo = (CryptoCustomerIdentityInformation) appSession.getData(FragmentsCommons.IDENTITY_INFO);

        if (identityInfo != null) {
            final String accuracyString = Long.toString(identityInfo.getAccuracy());
            accuracy.setText(accuracyString);

            if (!(identityInfo.getFrequency() == null)) {
                int spinnerPosition = dataAdapter.getPosition(identityInfo.getFrequency());
                frequency.setSelection(spinnerPosition);
            }
        } else {
            accuracy.setText("10");
            frequency.setSelection(1);
        }
    }
}