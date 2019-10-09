package com.http.shiller.second;

public interface Matcher {
    double match(String base, String pattern);

    boolean anyMatch(String base, String pattern);
}
