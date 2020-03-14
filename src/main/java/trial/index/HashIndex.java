package trial.index;

import java.util.*;
import trial.util.*;

class HashIndex {
    public static void main(String[] arguments) {
        HashSet<Integer> one = makeSet(1000000);
        HashSet<Integer> two = makeSet(1000000);
        Timing.timing(() -> {
            ArrayList<Integer> result = new ArrayList<>();
            for (Integer i : one) {
                if (two.contains(i)) {
                    result.add(i);
                }
            }
            return result;
        });
    }

    public static HashSet<Integer> makeSet(int count) {
        int max = count * 2;
        Random random = new Random();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < count; ++i) {
            int v = random.nextInt(max);
            while (result.contains(v)) {
                v = random.nextInt(max);
            }
            result.add(v);
        }
        return result;
    }
}