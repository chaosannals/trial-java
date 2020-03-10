package trial.util;

import java.util.function.*;

public abstract class Timing {
    public static <T> T timing(Supplier<T> action) {
        long start = System.nanoTime();
        T result = action.get();
        long end = System.nanoTime();
        double interval = (end - start) / 1000000;
        System.out.println(String.format("%.8g", interval));
        return result;
    }
}