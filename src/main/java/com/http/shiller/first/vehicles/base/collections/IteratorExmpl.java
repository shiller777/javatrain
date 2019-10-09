package com.http.shiller.first.vehicles.base.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExmpl {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        IteratorExample<Integer> example = new IteratorExample<>(integers);

//        Iterator<Integer> iterator = example.iterator();
//        while (iterator.hasNext()) {
//            Integer element = iterator.next();
//            if (element == 2) {
//                iterator.remove();
//            }
//        }
//        System.out.println(integers);
    }

    private static class IteratorExample<T> implements Iterable<T> {

        private List<T> integers;
        private int currentPosition = -1;

        public IteratorExample(List<T> integers) {
            this.integers = integers;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    int index = currentPosition + 2;
                    return integers.size() > index;
                }

                @Override
                public T next() {
                    return integers.get(++currentPosition);
                }

                @Override
                public void remove() {
                    integers.remove(currentPosition);
                    currentPosition--;
                }
            };
        }
    }
}
