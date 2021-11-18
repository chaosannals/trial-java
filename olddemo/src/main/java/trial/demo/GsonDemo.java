package trial.demo;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import trial.demo.demo.One;

public class GsonDemo {
    
    @SuppressWarnings("unchecked")
    public static void readJsonOne() {
        InputStream is = GsonDemo.class.getResourceAsStream("/one.json");
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        One one = gson.fromJson(new InputStreamReader(is), One.class);
        for (Map.Entry<String, Object> e: one.getFiles().entrySet()) {
            System.out.println(e.getValue().getClass());
            if (e.getValue() instanceof ArrayList) {
                for(String i: (ArrayList<String>)e.getValue()) {
                    System.out.println(String.format("%s %s", e.getKey(), i));
                }
            } else {
                System.out.println(String.format("%s %s", e.getKey(), e.getValue()));
            }
        }
    }
}
