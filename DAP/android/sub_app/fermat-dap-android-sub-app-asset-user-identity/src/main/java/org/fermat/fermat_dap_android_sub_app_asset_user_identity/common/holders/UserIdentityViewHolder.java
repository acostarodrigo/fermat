package org.fermat.fermat_dap_android_sub_app_asset_user_identity.common.holders;

import android.view.View;
import android.widget.ImageView;

import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatTextView;
import com.bitdubai.fermat_android_api.ui.holders.FermatViewHolder;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_identity_bitdubai.R;

/**
 * Created by nelson on 01/09/15.
 */
public class UserIdentityViewHolder extends FermatViewHolder {

    private ImageView identityImage;
    private FermatTextView identityName;

    public UserIdentityViewHolder(View itemView) {
        super(itemView);

        identityImage = (ImageView) itemView.findViewById(R.id.crypto_broker_identity_image);
        identityName = (FermatTextView) itemView.findViewById(R.id.crypto_broker_identity_alias);
    }

    public ImageView getIdentityImage() {
        return identityImage;
    }

    public FermatTextView getIdentityName() {
        return identityName;
    }
}
