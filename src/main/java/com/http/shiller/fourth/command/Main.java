package com.http.shiller.fourth.command;

import java.beans.beancontext.BeanContextChildSupport;

public class Main {
    public static void main(String[] args) {
        CommandExecutor.executeCommand("print", "sss", 1, 2L, new BeanContextChildSupport());
        CommandExecutor.executeCommand("doSome");


    }
}
