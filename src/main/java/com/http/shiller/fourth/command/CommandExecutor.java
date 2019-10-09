package com.http.shiller.fourth.command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("print", (params) -> {
            System.out.println("PRINT EXECUTED");
            System.out.println("Params:" + Arrays.toString(params));
        });
        commands.put("doSome", (params) -> {
            System.out.println("Fuck u");
        });
    }

    public static void executeCommand(String commandName, Object... params) {
        Command command = commands.get(commandName);
        command.execute(params);
    }
}
