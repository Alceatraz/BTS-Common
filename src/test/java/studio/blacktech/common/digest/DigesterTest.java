package studio.blacktech.common.digest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.digest.Digester;
import studio.blacktech.common.crypto.digest.SHA256Digester;

import javax.crypto.SecretKey;

public class DigesterTest {


    @Test
    void test1() {


        String a = "0123456789";


        System.out.println(Digester.md5(a));
        System.out.println(Digester.sha256(a));
        System.out.println(Digester.sha384(a));
        System.out.println(Digester.sha512(a));


    }


    @Test
    void test2() {

        String secret = "0123456789ABCDEF";
        String message = "0123456789ABCDEF";

        SecretKey secretKey = SHA256Digester.getSecretKey(secret);

        SHA256Digester digester1 = new SHA256Digester(secretKey);
        SHA256Digester digester2 = new SHA256Digester(secretKey);

        String temp1 = digester1.digest(message);
        String temp2 = digester2.digest(message);

        Assertions.assertEquals(temp1, temp2);
        Assertions.assertTrue(digester2.check(temp1, message));


    }

}
