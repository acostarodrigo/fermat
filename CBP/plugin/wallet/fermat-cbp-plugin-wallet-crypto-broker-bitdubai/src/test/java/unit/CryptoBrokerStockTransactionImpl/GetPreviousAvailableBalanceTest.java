package unit.CryptoBrokerStockTransactionImpl;

import com.bitdubai.fermat_cbp_plugin.layer.wallet.crypto_broker.developer.bitdubai.version_1.structure.util.CryptoBrokerStockTransactionImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by José Vilchez on 21/01/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetPreviousAvailableBalanceTest {

    @Test
    public void getPreviousAvailableBalance() {
        CryptoBrokerStockTransactionImpl cryptoBrokerStockTransaction = mock(CryptoBrokerStockTransactionImpl.class);
        when(cryptoBrokerStockTransaction.getPreviousAvailableBalance()).thenReturn(BigDecimal.ONE);
        assertThat(cryptoBrokerStockTransaction.getPreviousAvailableBalance()).isNotNull();
    }

}
