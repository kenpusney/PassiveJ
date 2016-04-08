package net.kimleo.model;

import java.util.*;

public class CollectionHelper {
    @SafeVarargs
    public static <T> Set<T> setOf(T... ts) {
        HashSet<T> set = new HashSet<>();
        Collections.addAll(set, ts);
        return set;
    }

    @SafeVarargs
    public static <T> List<T> listOf(T... accept) {
        List<T> ts = new ArrayList<>();
        Collections.addAll(ts, accept);
        return ts;
    }

}
