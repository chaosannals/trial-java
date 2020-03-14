package trial.util;

import java.text.*;
import java.util.function.*;

public abstract class Timing {
    private static DecimalFormat df = new DecimalFormat("0.000000");

    public static <T> T timing(Supplier<T> action) {
        long start = System.nanoTime();
        T result = action.get();
        long end = System.nanoTime();
        double interval = (end - start) * 0.000000001;
        System.out.println(df.format(interval));
        return result;
    }
}