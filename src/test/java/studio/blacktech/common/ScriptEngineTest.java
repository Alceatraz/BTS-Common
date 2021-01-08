package studio.blacktech.common;

import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptEngineTest {


    @Test
    void Test() throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");


        Object result = engine.eval("4*5");
        System.out.println(result.getClass().getName());
        System.out.println(result);

        for (ScriptEngineFactory engineFactory : manager.getEngineFactories()) {
            System.out.println(engineFactory.getEngineName());
        }


    }

}
