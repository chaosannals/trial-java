package trial;

import java.io.IOException;
import java.nio.file.*;
import java.security.NoSuchAlgorithmException;

import trial.util.*;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        try {
            // String c = Files.readString(Path.of("license"));
            // String c = FileUtil.readAll("license");
            // System.out.println(c);
            // for(Path p: FileUtil.listDir(".")) {
            //     System.out.println(p.getFileName());
            // }
            Timing.timing(() -> {
                try {
                    String r = HashUtil.hashHexFrom("MD5", "license");
                    System.out.println(r);
                } catch (NoSuchAlgorithmException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return null;
            });
        } catch (Exception e) {

        }
    }
}
