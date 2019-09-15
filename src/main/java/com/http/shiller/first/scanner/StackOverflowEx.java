package com.http.shiller.first.scanner;

public class StackOverflowEx {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println(++i);
        main(new String[]{});
    }
}
