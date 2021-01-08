package studio.blacktech.common.random;

import org.junit.jupiter.api.Test;
import studio.blacktech.common.crypto.random.RandomTool;

public class RandomTest {


    @Test
    void test() {

        System.out.println(RandomTool.nextInt());
        System.out.println(RandomTool.nextInt(100));
        System.out.println(RandomTool.nextInt(100, 200));

        System.out.println(RandomTool.randomBASE58(32));
        System.out.println(RandomTool.randomBASE64(32));

    }


}
