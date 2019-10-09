package com.http.shiller.fourth;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringsTest {
    static StringBuilder builder;
    static String s;

    @BeforeAll
    static void init() {
        builder = new StringBuilder();
        s = "as";
    }


    @Test
    void testBuilder(String eqw) {
    }

    @Test
    void testStr() {
        doTest("SADA");
    }

    void doTest(String str) throws RuntimeException {
        doTest(str);
    }

}