package studio.blacktech.common.cipgher;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.cipher.RSACipher;


public class RSATest {


    @Test
    void test() {

        RSACipher cipher = new RSACipher(512);

        String pub = cipher.getEncodedPublicKey();
        String pri = cipher.getEncodedPrivateKey();

        RSACipher publicSide = new RSACipher(RSACipher.getRSAPublicKey(pub));
        RSACipher privateSide = new RSACipher(RSACipher.getRSAPrivateKey(pri));

        String raw = "0123456789ABCDEF";

        String tmp = publicSide.encrypt(raw);
        String res = privateSide.decrypt(tmp);

        Assertions.assertEquals(raw, res);

        String signature = privateSide.signature(raw);

        Assertions.assertTrue(publicSide.verify(raw, signature));

    }


}
