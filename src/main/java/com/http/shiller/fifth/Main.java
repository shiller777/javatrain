package com.http.shiller.fifth;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        MainClass mainClass = new MainClass();
//        MainClass.Inner inner = mainClass.new Inner(1);
////        MainClass.Inner inner1 = new MainClass.Inner();
//        System.out.println(inner.getI());
//
//
//        MainClass.StaticInner staticInner = new MainClass.StaticInner(2);
//        System.out.println(staticInner.getI());
//
//        MainClass.StaticInner staticInner1 = new MainClass.StaticInner(3);
//        System.out.println(staticInner.getI());
//        System.out.println(staticInner1.getI());
//        buttonExample();
        polymorph();

    }


    protected static void buttonExample() {
        Deque integer = new LinkedList();

        ArrayDeque s = ((ArrayDeque) integer);

        Button.OnClick onClick = () -> {
            System.out.println("clicked");
            System.out.println("clicked");
            System.out.println("clicked");
            System.out.println("clicked");
        };

        Button button = new Button(onClick);
        button.clicked();

        button = new Button();
        button.clicked();

//        Button.OnClick onClick = () -> System.out.println("clicked");
    }

    private static void polymorph(){
        MainClass mainClass = new ExtendFromMainClass();
        mainClass.print(new ArrayList());

    }
}
