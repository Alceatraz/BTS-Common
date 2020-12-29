package studio.blacktech.common.random;

import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.random.Randomity;

public class RandomTest {


    @Test
    void test() {

        System.out.println(Randomity.nextInt());
        System.out.println(Randomity.nextInt(100));
        System.out.println(Randomity.nextInt(100, 200));

        System.out.println(Randomity.randomBASE58(32));
        System.out.println(Randomity.randomBASE64(32));

    }


}
