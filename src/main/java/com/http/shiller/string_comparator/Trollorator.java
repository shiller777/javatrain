package com.http.shiller.string_comparator;

import java.util.Comparator;

import static com.http.shiller.string_comparator.TrololoUtil.*;

public class Trollorator implements Comparator<String> {

    public int compare(String o1, String o2) {
        int less = o1.length() < o2.length() ?
                o1.length() : o2.length();
        int lalala = o1.length() - o2.length();

        for (int i = 0; i < less; i++) {
            //byte ololol = (byte) (o1.charAt(i) - o2.charAt(i));
            byte ololol = (byte) (toUpperCase(o1.charAt(i)) - toUpperCase(o2.charAt(i)));
            if (ololol != 0) {
                return ololol;
            }
        }
        return lalala;
    }

}
