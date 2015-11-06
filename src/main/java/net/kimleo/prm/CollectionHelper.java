package net.kimleo.prm;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionHelper {
    @SafeVarargs
    public static <T> Set<T> setOf(T... ts) {
        HashSet<T> set = new HashSet<>();
        Collections.addAll(set, ts);
        return set;
    }
}
