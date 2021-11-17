package trial.util;

import java.io.*;
import java.util.*;

public class CommandUtil {
    public static String[] getEnvs() {
        ArrayList<String> result = new ArrayList<String>();
        Map<String, String> envm = System.getenv();
        envm.forEach((k, v) -> {
            result.add(String.format("%s=%s", k, v));
        });
        return result.toArray(new String[result.size()]);
    }

    public static String run(String cmd) throws IOException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(cmd);
        return readToEnd(p);
    }

    public static String run(String cmd, String[] envs, File dir) throws IOException {
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(cmd, envs, dir);
        return readToEnd(p);
    }

    public static String readToEnd(Process p) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(readToEnd(p.getInputStream()));
        sb.append(readToEnd(p.getErrorStream()));
        return sb.toString();
    }

    public static String readToEnd(InputStream s) throws IOException {
        InputStreamReader reader = new InputStreamReader(s);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String message = br.readLine();
            if (message == null) {
                break;
            }
            sb.append(message);
        }
        return sb.toString();
    }
}
