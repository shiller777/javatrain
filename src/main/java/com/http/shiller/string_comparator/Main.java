package com.http.shiller.string_comparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> trolloStrings = new ArrayList<>();

        trolloStrings.add("aSdfgh");
        trolloStrings.add("Asdfgh");
        trolloStrings.add("asdfgh2");
        trolloStrings.add("asdfgH1");

        trolloStrings.sort(new Trollorator());

        trolloStrings.forEach(System.out::println);
    }
}
