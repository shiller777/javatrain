package com.http.shiller.first.algo;

public class Cycles {

    public static void main(String[] args) {
        int[] fibanachiArray = new int[20];

        fibanachiArray[0] = 0;
        fibanachiArray[1] = 1;

        int plusResult;
        int minusResult;

        for (int i = 2; i < fibanachiArray.length; i++) {

            boolean straightDirection = true;

            while (i < fibanachiArray.length) {
                plusResult = fibanachiArray[i - 2] + fibanachiArray[i - 1];
                minusResult = fibanachiArray[i - 1] - fibanachiArray[i - 2];
                if (plusResult > 100 && minusResult < 0) {
                    minusResult = fibanachiArray[i - 2] - fibanachiArray[i - 1];
                }
                if (straightDirection) {
                    if (plusResult <= 100) {
                        fibanachiArray[i] = plusResult;
                        i++;
                    } else {
                        straightDirection = false;
                        continue;
                    }

                } else {
                    if (minusResult >= 0) {
                        fibanachiArray[i] = minusResult;
                        i++;
                    } else {
                        straightDirection = true;
                        continue;
                    }
                }
            }

        }

        for (int i = 0; i < fibanachiArray.length; i++) {
            System.out.println("i = " + i + "fibanachi[" + i + "] = " + fibanachiArray[i]);
        }

    }
}
