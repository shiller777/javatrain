package com.http.shiller.fourth.statusExample;

import java.util.List;
import static java.lang.Math.*;

public class Util {
    public static <T> void checkStatus(List<T> things) throws Exception {
        for (T t : things) {
            if (t instanceof HasStatus) {
                if (((HasStatus<Status>) t).getStatus().equals(Status.ACTUAL)) {
                    System.out.println("Ok");
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        }
    }
}
