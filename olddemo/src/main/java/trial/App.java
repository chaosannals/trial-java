package trial;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.security.NoSuchAlgorithmException;

import trial.demo.GsonDemo;
import trial.util.*;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        try {
            String path = "test.exe";
            byte[] a = Files.readAllBytes(Path.of(path));
            byte[] b = FileUtil.readAllBytes(path);

            System.out.printf("%d : %d \n", a.length, b.length);

            for(int i = 0; i < a.length; ++i) {
                if (a[i] != b[i]) {
                    System.out.printf("%d != %d \n", a[i], b[i]);
                    break;
                }
            }

            // Map<String, String> envm = System.getenv();
            // HashMap<String, String> nenvm = new HashMap<>(envm);
            // nenvm.put("aaa", "aaa");
            // GsonDemo.readJsonOne();
            // String c = Files.readString(Path.of("license"));
            // String c = FileUtil.readAll("license");
            // System.out.println(c);
            // for(Path p: FileUtil.listDir(".")) {
            // System.out.println(p.getFileName());
            // }

            // try {
            //     FileUtil.writeTo("runtimes/aaa.txt", "test");
            //     FileUtil.copyFile("runtimes/aaa.txt", "runtimes/bbb/bbb.txt");
            //     // String[] envs = CommandUtil.getEnvs();
            //     // String r = CommandUtil.run("java -version", envs, new File("."));
            //     // System.out.println(r);
            // } catch (IOException e) {
            //     System.out.println(e);
            // }
            // Timing.timing(() -> {
            // System.out.println(System.getenv());
            // for (String e : CommandUtil.getEnvs()) {
            // System.out.println(e);
            // }

            // try {
            // String r = HashUtil.hashHexFrom("MD5", "license");
            // System.out.println(r);
            // } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            // } catch (IOException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            // }
            // return null;
            // });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
