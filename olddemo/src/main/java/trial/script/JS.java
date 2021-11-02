package trial.script;

import javax.script.*;

public class JS {
    public static void main(String[] arguments) {
        try {
            // 使用内置 JS 引擎进行计算
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put("age", 20);
            engine.put("two", 2.1);
            engine.eval("age = age * 20 / two");
            Object result = engine.get("age");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
