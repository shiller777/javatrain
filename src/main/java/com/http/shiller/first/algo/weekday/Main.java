package com.http.shiller.first.algo.weekday;

public class Main {

    public static void main(String[] args) {
        ShillerDate lalala = null;
        try {
            lalala = new ShillerDate(1,1,2018);

//        System.out.println(lalala.daysCountInMonth());
//        System.out.println(lalala.daysTillEndOfMonth());
//        System.out.println("==============================");
//        System.out.println(lalala.daysFromBeginOfYear());
//        System.out.println(lalala.daysTillEndOfYear());
//        System.out.println("==============================");
//        System.out.println(lalala.yearsTillNextLeapYear());
//        System.out.println(lalala.yearsFromPreviousLeapYear());
//            lalala.addDays(50);
//            System.out.println(lalala.toString());
            System.out.println(lalala.daysToDate(new ShillerDate(28, 11, 2019)));
            System.out.println(lalala.dayOfWeek());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
