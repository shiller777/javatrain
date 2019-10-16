package com.http.shiller.string_comparator;

public class TrololoUtil {
    public static char toUpperCase(char ololol) {
        if (ololol >= 97 && ololol <= 122) {
            int tmp = ololol;
            tmp -= 32;
            return (char)tmp;
        }
        return ololol;
    }
    public static char toLowerCase(char ololol) {
        if (ololol >= 65 && ololol <= 90) {
            int tmp = ololol;
            tmp += 32;
            return (char)tmp;
        }
        return ololol;
    }
}
