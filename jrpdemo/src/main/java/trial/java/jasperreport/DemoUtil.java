package trial.java.jasperreport;

import java.io.*;

public class DemoUtil {
    public static String readResourceString(String name) throws IOException {
        InputStream is = App.class.getResourceAsStream(name);
        InputStreamReader reader = new InputStreamReader(is, "UTF-8");
        char[] buffer = new char[1024];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = reader.read(buffer);
            if (n < 0) {
                break;
            }
            sb.append(buffer, 0, n);
        }
        return sb.toString();
    }
}
