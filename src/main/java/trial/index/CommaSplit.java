package trial.index;

import java.util.regex.*;
import trial.util.*;

public class CommaSplit {
    public static void main(String[] arguments) {
        String text = "中文,English,1233,454";
        Timing.timing(() -> {
            Pattern pattern = Pattern.compile("(.+?)(,.+)");
            Matcher m = pattern.matcher(text);
            if (m.find()) {
                System.out.println(m.group(2));
            }
        });
    }
}