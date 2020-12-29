package studio.blacktech.common.digest;

import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.digest.Digester;

public class DigesterTest {


    @Test
    void test() {


        String a = "0123456789";


        System.out.println(Digester.md5(a));
        System.out.println(Digester.sha256(a));
        System.out.println(Digester.sha384(a));
        System.out.println(Digester.sha512(a));


    }

}
