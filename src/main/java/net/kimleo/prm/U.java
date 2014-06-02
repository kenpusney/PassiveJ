package net.kimleo.prm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kim on 2014/5/30.
 */
public class U {
    public static <T> Set<T> set(T... ts) {
        HashSet<T> set = new HashSet<>();
        for (T t:ts)
            set.add(t);
        return set;
    }
}
