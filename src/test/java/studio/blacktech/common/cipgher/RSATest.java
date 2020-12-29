package studio.blacktech.common.cipgher;


import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.cipher.RSACipher;


public class RSATest {


    @Test
    void test() {

        RSACipher cipher = new RSACipher(512);

        String pub = cipher.getEncodedPublicKey();
        String pri = cipher.getEncodedPrivateKey();

        System.out.println(pub);
        System.out.println(pri);

        RSACipher publicSide = new RSACipher(RSACipher.getRSAPublicKey(pub));
        RSACipher privateSide = new RSACipher(RSACipher.getRSAPrivateKey(pri));

        String raw = "飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦飞机卡拉第三方翻开历史交锋技术的覅哦价位附近为哦附件付款记录请问是否就OK请问为风口浪尖的封建王权覅哦评价为哦附件为解耦";

        String signature = privateSide.signature(raw);

        System.out.println(signature);

        System.out.println(publicSide.verify(raw, signature));

        String tmp = publicSide.encrypt(raw);

        System.out.println(tmp);

        String res = privateSide.decrypt(tmp);

        System.out.println(raw.equals(res));


    }


}
