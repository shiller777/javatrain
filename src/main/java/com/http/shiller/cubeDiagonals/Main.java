package com.http.shiller.cubeDiagonals;

import com.http.shiller.logger.BaseLogger;
import com.http.shiller.logger.GodzillaLogger;
import com.http.shiller.logger.Logger;
import com.http.shiller.logger.MonsterLogger;

public class Main {
    private static Logger logger = new BaseLogger();
//    private static Logger logger2 = new MonsterLogger();
//    private static Logger logger3 = new MonsterLogger(true, "C:\\Test\\lalala.txt", "C:\\Test\\ololol.txt");
    //private static Logger logger4 = new GodzillaLogger(true, "C:\\Test\\lalala.txt", "C:\\Test\\ololol.txt");
    private static GodzillaLogger loggerGodzilla = new GodzillaLogger();

    public static void main(String[] args) {

//        printDiag1(9);
//        printDiag2(9);
//        printDiag3(9);
//        printDiag4(9);

        loggerGodzilla.addPrintFile("C:\\Test\\ololol.txt", true, true, 300);

        printOppositePoints(9, new Point(9, 9, 9));

        System.out.println("==============================================");
        printOppositePoints3(9, new Point(2, 2, 1));
        System.out.println("==============================================");
        printOppositePoints3(9, new Point(8, 8, 9));

        System.out.println("==============================================");
        printOppositePoints3(9, new Point(9, 9, 9));
        System.out.println("==============================================");
        printOppositePoints3(9, new Point(1, 1, 1));

    }


    public static void printOppositePoints(int cubeSide, Point point) {

        loggerGodzilla.info("now works!");
        loggerGodzilla.info("asdf");
        loggerGodzilla.info("qwerty");
        loggerGodzilla.info("zxcv");
        loggerGodzilla.info("asdf");
        loggerGodzilla.info("qwerty");
        loggerGodzilla.info("zxcv");
        loggerGodzilla.checkAndArchieve();

        for (int i = 1; i <= cubeSide; i += (cubeSide - 1)) {
            for (int j = 1; j <= cubeSide; j += (cubeSide - 1)) {
                for (int k = 1; k <= cubeSide; k += (cubeSide - 1)) {
                    if (!(i == point.x && j == point.y && k == point.z)) {
                        logger.info(new Point(i, j, k).toString());
                    }
                }
            }
        }
    }


    public static void printOppositePoints3(int cubeSide, Point point) {

        int baseX;
        int baseY;
        int baseZ;

        int offsetX;
        int offsetY;
        int offsetZ;

        int multiplierX;
        int multiplierY;
        int multiplierZ;


        if (point.x > cubeSide / 2) {
            baseX = cubeSide;
            offsetX = baseX - point.x;
        } else {
            baseX = 1;
            offsetX = point.x - baseX;
        }

        if (point.y > cubeSide / 2) {
            baseY = cubeSide;
            offsetY = baseY - point.y;
        } else {
            baseY = 1;
            offsetY = point.y - baseY;
        }
        if (point.z > cubeSide / 2) {
            baseZ = cubeSide;
            offsetZ = baseZ - point.z;
        } else {
            baseZ = 1;
            offsetZ = point.z - baseZ;
        }

        for (int i = 1; i <= cubeSide; i += (cubeSide - 1)) {
            for (int j = 1; j <= cubeSide; j += (cubeSide - 1)) {
                for (int k = 1; k <= cubeSide; k += (cubeSide - 1)) {
                    if (!(i == baseX && j == baseY && k == baseZ)) {
                        //logger.info("Base " + new Point(i, j, k).toString());

                        if (i == cubeSide) {
                            multiplierX = -1;
                        } else {
                            multiplierX = 1;
                        }
                        if (j == cubeSide) {
                            multiplierY = -1;
                        } else {
                            multiplierY = 1;
                        }
                        if (k == cubeSide) {
                            multiplierZ = -1;
                        } else {
                            multiplierZ = 1;
                        }

                        logger.info("Expected " +
                                new Point(i + multiplierX * offsetX,
                                        j + multiplierY * offsetY,
                                        k + multiplierZ * offsetZ).toString());

                    }
                }
            }
        }
    }


    public static void printDiag1(int cubeSide) {
        System.out.println("Cube diagonal 1:");
        for (int i = 1; i <= cubeSide; i++) {
            logger.info(String.format("Element(%d, %d, %d)", i, i, i));
        }
    }

    public static void printDiag2(int cubeSide) {
        System.out.println("Cube diagonal 2:");
        for (int i = 1; i <= cubeSide; i++) {
            logger.info(String.format("Element(%d, %d, %d)", i, cubeSide + 1 - i, cubeSide + 1 - i));
        }
    }

    public static void printDiag3(int cubeSide) {
        System.out.println("Cube diagonal 3:");
        for (int i = 1; i <= cubeSide; i++) {
            logger.info(String.format("Element(%d, %d, %d)", i, cubeSide + 1 - i, i));
        }
    }

    public static void printDiag4(int cubeSide) {
        System.out.println("Cube diagonal 4:");
        for (int i = 1; i <= cubeSide; i++) {
            logger.info(String.format("Element(%d, %d, %d)", i, i, cubeSide + 1 - i));
        }
    }
}
