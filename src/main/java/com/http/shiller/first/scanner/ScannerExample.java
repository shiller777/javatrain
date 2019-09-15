package com.http.shiller.first.scanner;

import java.util.Scanner;

public class ScannerExample {

    static char[] symbols = {'+', '-', '*', '/'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Print your expression");
            String input = scanner.nextLine();
            try {
                char operType = readSymbol(input);
                int[] numbers = readNumbers(input, operType);
                double result = performOperation(numbers[0], numbers[1], operType);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    private static char readSymbol(String input) throws Exception {
        //talk about auto(un)package
        char result = 0;
        for (Character symbol : symbols) {
            if (input.contains(symbol.toString())) {
                result = symbol;
                break;
            }
        }
        if (result == 0) {
            throw new Exception("stupid input");
        }
        return result;
    }

    private static int[] readNumbers(String input, Character operation) {
        int[] numbers = new int[2];
        int operationIndex = input.indexOf(operation.toString());

        numbers[0] = Integer.parseInt(input
                .substring(0, operationIndex)
                .trim());

        numbers[1] = Integer.parseInt(input
                .substring(operationIndex + 1)
                .trim());
        return numbers;
    }

    private static double performOperation(int num1, int num2, char operation) throws Exception {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new Exception("Division by 0");
                }
                result = num1 / num2;
                break;
            default:
                throw new Exception("Ыегзшв штзге 2");

        }
        return result;
    }
}
