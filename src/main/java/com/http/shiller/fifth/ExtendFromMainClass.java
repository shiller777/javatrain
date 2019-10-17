package com.http.shiller.fifth;

import java.util.*;

public class ExtendFromMainClass extends MainClass {

    @Override
    public void print(List list) {
        super.print(list);
    }

    @Override
    public void print(Integer i) {
        System.out.println("HELLOU");
    }

    private void doLikeSomething() {
        System.out.println("SOMETHING");
    }

}
