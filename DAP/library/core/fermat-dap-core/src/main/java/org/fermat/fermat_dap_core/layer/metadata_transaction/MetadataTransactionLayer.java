package org.fermat.fermat_dap_core.layer.metadata_transaction;

import com.bitdubai.fermat_api.layer.all_definition.enums.Layers;
import com.bitdubai.fermat_core_api.layer.all_definition.system.abstract_classes.AbstractLayer;
import com.bitdubai.fermat_core_api.layer.all_definition.system.exceptions.CantStartLayerException;

import org.fermat.fermat_dap_core.layer.metadata_transaction.asset_incoming.AssetIncomingPluginSubsystem;
import org.fermat.fermat_dap_core.layer.metadata_transaction.asset_outgoing.AssetOutgoingPluginSubsystem;


/**
 * Created by Víctor A. Mars M. (marsvicam@gmail.com) on 12/04/16.
 */
public class MetadataTransactionLayer extends AbstractLayer {
    //VARIABLE DECLARATION

    //CONSTRUCTORS
    public MetadataTransactionLayer() {
        super(Layers.METADATA_TRANSACTION);
    }

    //PUBLIC METHODS
    @Override
    public void start() throws CantStartLayerException {
        try {

            registerPlugin(new AssetIncomingPluginSubsystem());
            registerPlugin(new AssetOutgoingPluginSubsystem());

        } catch (Exception e) {

            throw new CantStartLayerException(
                    e,
                    "Metadata Transaction Layer of DAP Platform",
                    "Problem trying to register a plugin."
            );
        }
    }
    //PRIVATE METHODS

    //GETTER AND SETTERS

    //INNER CLASSES
}
