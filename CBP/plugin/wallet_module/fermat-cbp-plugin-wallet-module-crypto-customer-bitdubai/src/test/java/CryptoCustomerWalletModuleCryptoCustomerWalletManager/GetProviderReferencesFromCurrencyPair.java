package CryptoCustomerWalletModuleCryptoCustomerWalletManager;
import com.bitdubai.fermat_api.layer.world.interfaces.Currency;
import com.bitdubai.fermat_cbp_api.all_definition.enums.CurrencyType;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.exceptions.CantCreateNewActorExtraDataException;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.exceptions.CantGetListActorExtraDataException;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.exceptions.CantGetListPlatformsException;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.exceptions.CantUpdateActorExtraDataException;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.interfaces.ActorExtraData;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.interfaces.ActorExtraDataManager;
import com.bitdubai.fermat_cbp_api.layer.actor.crypto_broker.interfaces.QuotesExtraData;
import com.bitdubai.fermat_cbp_api.layer.wallet_module.crypto_customer.exceptions.CantGetCurrentIndexSummaryForCurrenciesOfInterestException;
import com.bitdubai.fermat_cbp_plugin.layer.wallet_module.crypto_customer.developer.bitdubai.version_1.structure.CryptoCustomerWalletModuleCryptoCustomerWalletManager;
import com.bitdubai.fermat_cer_api.layer.provider.exceptions.CantGetProviderInfoException;
import com.bitdubai.fermat_cer_api.layer.search.exceptions.CantGetProviderException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by roy on 9/02/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetProviderReferencesFromCurrencyPair {
    @Test
    public void getProviderReferencesFromCurrencyPair() throws CantGetProviderException, CantGetProviderInfoException{
        CryptoCustomerWalletModuleCryptoCustomerWalletManager cryptoCustomerWalletModuleCryptoCustomerWalletManager = mock(CryptoCustomerWalletModuleCryptoCustomerWalletManager.class, Mockito.RETURNS_DEEP_STUBS);
        doCallRealMethod().when(cryptoCustomerWalletModuleCryptoCustomerWalletManager).getProviderReferencesFromCurrencyPair(Mockito.any(Currency.class), Mockito.any(Currency.class));
    }
}
