package trial.java.exe4jutil;

import java.io.IOException;

public class ProcessUtil {
    public static void run(String... cmd) throws InterruptedException, IOException {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.start();
        pb.wait();
    }
}
