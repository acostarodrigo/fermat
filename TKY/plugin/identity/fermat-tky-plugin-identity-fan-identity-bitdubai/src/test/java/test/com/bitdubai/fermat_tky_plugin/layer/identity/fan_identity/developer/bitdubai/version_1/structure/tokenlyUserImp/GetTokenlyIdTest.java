package test.com.bitdubai.fermat_tky_plugin.layer.identity.fan_identity.developer.bitdubai.version_1.structure.tokenlyUserImp;

import com.bitdubai.fermat_tky_plugin.layer.identity.fan_identity.developer.bitdubai.version_1.structure.TokenlyUserImp;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Created by gianco on 06/05/16.
 */
public class GetTokenlyIdTest {

    @Mock
    String id;

    @Test
    public void getTokenlyIdTest(){
        TokenlyUserImp tokenlyUserImp = Mockito.mock(TokenlyUserImp.class);

        when(tokenlyUserImp.getTokenlyId()).thenReturn(id);

    }
}
