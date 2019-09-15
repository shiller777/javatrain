package com.http.shiller.first.scanner;

public class RecEx {
    public Integer[] values = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        RecEx ex = new RecEx();
        ex.print(0);
    }

    public void print(int index) {
        System.out.println(values[index]);
        ++index;
        if (index < values.length) {
            print(index);
        }
    }
}
