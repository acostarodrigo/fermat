package com.bitdubai.reference_niche_wallet.loss_protected_wallet.common.popup;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.bitdubai.android_fermat_ccp_loss_protected_wallet_bitcoin.R;
import com.bitdubai.fermat_android_api.layer.definition.wallet.interfaces.ReferenceAppFermatSession;
import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatTextView;
import com.bitdubai.fermat_api.layer.all_definition.enums.Actors;
import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;
import com.bitdubai.fermat_api.layer.all_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_api.layer.all_definition.enums.ReferenceWallet;
import com.bitdubai.fermat_api.layer.all_definition.money.CryptoAddress;
import com.bitdubai.fermat_bch_api.layer.definition.crypto_fee.FeeOrigin;
import com.bitdubai.fermat_ccp_api.layer.wallet_module.loss_protected_wallet.exceptions.CantGetLossProtectedBalanceException;
import com.bitdubai.fermat_ccp_api.layer.wallet_module.loss_protected_wallet.exceptions.CantSendLossProtectedCryptoException;
import com.bitdubai.fermat_ccp_api.layer.wallet_module.loss_protected_wallet.exceptions.LossProtectedInsufficientFundsException;
import com.bitdubai.fermat_ccp_api.layer.wallet_module.loss_protected_wallet.interfaces.LossProtectedWallet;


/**
 * Created by Joaquin Carrasuquero on 11/04/16.
 */

public class Confirm_send_dialog extends Dialog implements
        View.OnClickListener {



    public Activity activity;
    public Dialog d;

    private BlockchainNetworkType blockchainNetworkType;
    private long cryptoAmount;
    private long fee;
    private long total;
    private CryptoAddress destinationAddress;
    private String notes;
    private String walletPublicKey;
    private String deliveredByActorPublicKey;
    private Actors deliveredByActorType;
    private String deliveredToActorPublicKey;
    private Actors deliveredToActorType;
    private ReferenceWallet referenceWallet;
    private FeeOrigin feeOrigin;

    /**
     *  Deals with crypto wallet interface
     */

    private LossProtectedWallet lossProtectedWallet;

    private ReferenceAppFermatSession<LossProtectedWallet> appSession;

    /**
     *  UI components
     */

    Button cancel_btn;
    Button accept_btn;
    FermatTextView confirmText;

    public Confirm_send_dialog(Activity a,
                               LossProtectedWallet lossProtectedWallet,//
                               long cryptoAmount,//
                               CryptoAddress destinationAddress,//
                               String notes, String walletPublicKey,
                               String deliveredByActorPublicKey,//
                               Actors deliveredByActorType,//
                               String deliveredToActorPublicKey,
                               Actors deliveredToActorType,
                               ReferenceWallet referenceWallet,
                               BlockchainNetworkType blockchainNetworkType,
                               ReferenceAppFermatSession<LossProtectedWallet> appSession) {
        super(a);
        this.activity = a;
        this.lossProtectedWallet=lossProtectedWallet;
        this.cryptoAmount = cryptoAmount;
        this.destinationAddress = destinationAddress;
        this.notes = notes;
        this.walletPublicKey = walletPublicKey;
        this.deliveredByActorPublicKey = deliveredByActorPublicKey;
        this.deliveredByActorType = deliveredByActorType;
        this.deliveredToActorPublicKey = deliveredToActorPublicKey;
        this.deliveredToActorType = deliveredToActorType;
        this.referenceWallet = referenceWallet;
        this.blockchainNetworkType = blockchainNetworkType;
        this.appSession = appSession;

    }

    public Confirm_send_dialog(Activity a,
                             LossProtectedWallet lossProtectedWallet,
                             long cryptoAmount,
                             long fee,
                             long total,
                             FeeOrigin feeOrigin,
                             CryptoAddress destinationAddress,
                             String notes,
                             String deliveredByActorPublicKey,
                             Actors deliveredByActorType,
                             BlockchainNetworkType blockchainNetworkType,
                             ReferenceAppFermatSession<LossProtectedWallet> appSession) {
        super(a);
        this.activity = a;
        this.lossProtectedWallet=lossProtectedWallet;
        this.cryptoAmount = cryptoAmount;
        this.destinationAddress = destinationAddress;
        this.notes = notes;
        this.deliveredByActorPublicKey = deliveredByActorPublicKey;
        this.deliveredByActorType = deliveredByActorType;
        this.fee = fee;
        this.total = total;
        this.feeOrigin = feeOrigin;
        this.blockchainNetworkType = blockchainNetworkType;
        this.appSession = appSession;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpScreenComponents();

    }

    private void setUpScreenComponents(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirmation_window);

        accept_btn = (Button) findViewById(R.id.accept_btn);
        cancel_btn = (Button) findViewById(R.id.cancel_btn);

        accept_btn.setOnClickListener(this);
        cancel_btn.setOnClickListener(this);

        getWindow().setBackgroundDrawable(new ColorDrawable(0));

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.cancel_btn) {
            //activity.finish();
            dismiss();
        }else if( i == R.id.accept_btn){
            try {

                //tengo que validar el balance real
                long realBalance = lossProtectedWallet.getRealBalance(appSession.getAppPublicKey(), blockchainNetworkType);

                if(cryptoAmount < realBalance) //Balance value is greater than send amount
                {
                    lossProtectedWallet.send(
                            this.cryptoAmount,
                            this.destinationAddress,
                            notes,
                            this.walletPublicKey,
                            this.deliveredByActorPublicKey,
                            this.deliveredByActorType,
                            this.deliveredToActorPublicKey,
                            this.deliveredToActorType,
                            this.referenceWallet,
                            blockchainNetworkType,
                            CryptoCurrency.BITCOIN,
                            0,
                            FeeOrigin.SUBSTRACT_FEE_FROM_AMOUNT

                    );
                }
                else
                {
                    Toast.makeText(this.activity, "Action not allowed, Insufficient Funds.", Toast.LENGTH_LONG).show();
                }

            } catch (CantSendLossProtectedCryptoException e) {
                e.printStackTrace();
                Toast.makeText(this.activity, "Unexpected error", Toast.LENGTH_SHORT).show();
            } catch (LossProtectedInsufficientFundsException e) {
                e.printStackTrace();
                Toast.makeText(this.activity, "Not enough funds to perform action", Toast.LENGTH_SHORT).show();
            } catch (CantGetLossProtectedBalanceException e) {
                Toast.makeText(this.activity, "Unexpected error", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this.activity, "Sending...", Toast.LENGTH_SHORT).show();
            dismiss();
        }
    }



}