package trial;

import java.io.*;
import java.nio.file.*;

import trial.util.*;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        try {
            // String c = Files.readString(Path.of("license"));
            String c = readAll("license");
            System.out.println(c);
            Timing.timing(() -> {

                return null;
            });
        } catch (Exception e) {

        }
    }

    private static String readAll(String path) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            StringBuilder b = new StringBuilder();
            char[] buffer = new char[1024];
            int n = 0;
            while ((n = r.read(buffer)) != -1) {
                String d = String.valueOf(buffer, 0, n);
                b.append(d);
            }
            return b.toString();
        }
    }
}
