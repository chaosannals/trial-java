package trial.index;

import java.util.*;
import trial.util.*;

class HashIndex {
    public static void main(String[] arguments) {
        HashSet<Integer> one = makeSet(1000000);
        HashSet<Integer> two = makeSet(1000000);
        int[] aa = toPrimitive(one.toArray());
        int[] ab = toPrimitive(two.toArray());
        Arrays.sort(aa);
        Arrays.sort(ab);

        Timing.timing(() -> {
            HashSet<Integer> result = new HashSet<>();
            for (Integer i : one) {
                if (two.contains(i)) {
                    result.add(i);
                }
            }
            return result;
        });
        Timing.timing(() -> {
            one.retainAll(two);
        });
        Timing.timing(() -> {
            int[] result = new int[aa.length];
            int i = 0;
            int j = 0;
            int k = 0;
            int ae = aa.length;
            int be = ab.length;
            while (i < ae && j < be) {
                if (aa[i] < ab[j]) {
                    ++i;
                } else if (aa[i] > ab[j]) {
                    ++j;
                } else {
                    result[k] = aa[i];
                    ++i;
                    ++j;
                    ++k;
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

    public static int[] toPrimitive(Object[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = (int)data[i];
        }
        return result;
    }
}