package studio.blacktech.common.cipgher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.cipher.AESCipher;

import javax.crypto.SecretKey;

public class AESTest {


    @Test
    void test() {

        AESCipher.DHExchanger aliceExchanger = new AESCipher.DHExchanger(8191);
        String alicePublicKey = aliceExchanger.init();

        AESCipher.DHExchanger bobExchanger = new AESCipher.DHExchanger();
        String bobPublicKey = bobExchanger.init(alicePublicKey);
        SecretKey bobKey = bobExchanger.generate();

        SecretKey aliceKey = aliceExchanger.generate(bobPublicKey);

        byte[] encoded1 = aliceKey.getEncoded();
        byte[] encoded2 = bobKey.getEncoded();

        Assertions.assertArrayEquals(encoded1, encoded2);

        AESCipher aliceCipher = new AESCipher(aliceKey);
        AESCipher bobCipher = new AESCipher(bobKey);
        String raw = "0123456789ABCDEF";
        String tmp = aliceCipher.encrypt(raw);
        String res = bobCipher.decrypt(tmp);

        Assertions.assertEquals(raw, res);

    }


}
