package studio.blacktech.common.cipgher;

import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.cipher.AESCipher;

import javax.crypto.SecretKey;
import java.util.Arrays;

public class AESTest {


    @Test
    void test() {

        AESCipher.DHExchanger aliceExchanger = new AESCipher.DHExchanger(512);
        String alicePublicKey = aliceExchanger.init();

        System.out.println(alicePublicKey);

        AESCipher.DHExchanger bobExchanger = new AESCipher.DHExchanger();
        String bobPublicKey = bobExchanger.init(alicePublicKey);
        SecretKey bobKey = bobExchanger.generate();

        System.out.println(bobPublicKey);

        SecretKey aliceKey = aliceExchanger.generate(bobPublicKey);

        byte[] encoded1 = aliceKey.getEncoded();
        byte[] encoded2 = bobKey.getEncoded();

        System.out.println(Arrays.equals(encoded1, encoded2));


        AESCipher aliceCipher = new AESCipher(aliceKey);


        AESCipher bobCipher = new AESCipher(bobKey);

        String raw = "风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分风口浪尖六位数飞机偶是飞机飞机穷富家穷为附件为哦风景区我额分";

        String tmp = aliceCipher.encrypt(raw);

        String res = bobCipher.decrypt(tmp);

        System.out.println(raw.equals(res));

    }

}
