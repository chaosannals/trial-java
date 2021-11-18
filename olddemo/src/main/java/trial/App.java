package trial;

import java.io.*;
import java.nio.file.*;
import java.security.NoSuchAlgorithmException;

import trial.demo.GsonDemo;
import trial.util.*;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        try {
            GsonDemo.readJsonOne();
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
