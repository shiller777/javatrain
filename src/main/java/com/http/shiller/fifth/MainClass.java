package com.http.shiller.fifth;

import lombok.Getter;

import java.util.Collection;
import java.util.List;

class MainClass implements MainInterface{

    public static StaticInner getStaticInner(int i) {
        return new StaticInner(i);
    }

    @Override
    public void print(List list) {
        this.print(2);
    }

    public void print(Integer i) {
        System.out.println("!!!!!!HI");
    }


    public class Inner {
        @Getter
        /*static*/ int i;

        public Inner(int i) {
            this.i = i;
        }

    }

    public static class StaticInner {
        @Getter
        /*static*/ int i;

        public StaticInner(int i) {
            this.i = i;
        }

    }
}
