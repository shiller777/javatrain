package com.http.shiller.fourth;

import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            some();
        } catch (CustomException | FileNotFoundException e){
            System.out.println();
        }
    }

    private static void some() throws CustomException, FileNotFoundException {
        Random r = new Random();
        int num = r.nextInt();
        if (num % 2 == 0) {
            throw new CustomException("Hey");
        } else {
            throw new FileNotFoundException("Hey");
        }
    }
}
