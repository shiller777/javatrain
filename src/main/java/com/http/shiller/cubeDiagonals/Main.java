package com.http.shiller.cubeDiagonals;

public class Main {
    public static void main(String[] args) {

//        printDiag1(9);
//        printDiag2(9);
//        printDiag3(9);
//        printDiag4(9);
        printOppositePoints(9, new Point(9,9,9));
    }


    private static void printOppositePoints(int cubeSide, Point point) {
        for (int i = 1; i <= cubeSide; i+=(cubeSide - 1)) {
            for (int j = 1; j <= cubeSide; j+=(cubeSide - 1)) {
                for (int k = 1; k <= cubeSide; k+=(cubeSide - 1)) {
                    if (!(i == point.x && j == point.y && k == point.z)) {
                        System.out.println(new Point(i, j, k));
                    }
                }
            }
        }
    }

    public static void printDiag1(int cubeSide) {
        System.out.println("Cube diagonal 1:");
        for (int i = 1; i <= cubeSide; i++) {
            System.out.println(String.format("Element(%d, %d, %d)", i, i, i));
        }
    }

    public static void printDiag2(int cubeSide) {
        System.out.println("Cube diagonal 2:");
        for (int i = 1; i <= cubeSide; i++) {
            System.out.println(String.format("Element(%d, %d, %d)", i, cubeSide + 1 - i, cubeSide + 1 - i));
        }
    }

    public static void printDiag3(int cubeSide) {
        System.out.println("Cube diagonal 3:");
        for (int i = 1; i <= cubeSide; i++) {
            System.out.println(String.format("Element(%d, %d, %d)", i, cubeSide + 1 - i, i));
        }
    }

    public static void printDiag4(int cubeSide) {
        System.out.println("Cube diagonal 4:");
        for (int i = 1; i <= cubeSide; i++) {
            System.out.println(String.format("Element(%d, %d, %d)", i, i, cubeSide + 1 - i));
        }
    }
}
