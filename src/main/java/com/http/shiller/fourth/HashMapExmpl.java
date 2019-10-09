package com.http.shiller.fourth;

import com.http.shiller.fourth.statusExample.Book;

import java.util.HashMap;
import java.util.Map;

public class HashMapExmpl {
    private static Map<Book, Integer> marks = new HashMap<>();

    public static void main(String[] args) {
        Book book1 = new Book(2);
        Book book3 = new Book(124341);
        marks.put(book1, 1);
        marks.put(book3, 2);
        System.out.println(marks.get(book3));
        System.out.println(marks.get(book1));
    }
}
