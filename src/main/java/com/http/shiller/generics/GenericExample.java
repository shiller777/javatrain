package com.http.shiller.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public <T> List<T> doSome(List<Object> objects) {
        System.out.println(objects.get(0).getClass().getName());
        List<T> list = (List<T>) objects;
        return list;
    }

    public <T extends Number, V> void cast(T t, V v) {
        Object o = (Object) t;
        t.equals(v);
    }

    public <T, V extends Number> void cast(T t, V v) {
        int i = v.intValue();
    }

    public static void main(String[] args) {
        ArrayList<Integer> extList = new ArrayList<>();
        extList.add(1);
        ArrayList<Integer> superList = new ArrayList<>();
        superList.add(2);
        Integer integer = get(extList, superList, 5);
        System.out.println(integer);
    }

    public static <T> T get(List<? extends T> extList, List<? super T> superList, T t) {
        superList.add(t);
        T t1 = (T) superList.get(0);
        T t2 = extList.get(0);
        return t1;
    }
}
