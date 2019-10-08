package com.http.shiller.first.algo.weekday;

public class Main {

    public static void main(String[] args) {
        ShillerDate lalala = null;
        ShillerDate ololol = null;
        ShillerDate wow = null;
        try {

            ololol = new ShillerDate(25, 2, 2012);
            ololol.addDays(50);
            ololol.removeDays(50);
            System.out.println(ololol.toString());

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
            System.out.println(lalala.dayOfWeekHuman());

            lalala.removeDays(50);
            System.out.println(lalala.toString());

            wow = new ShillerDate(1, 1, 1);
            System.out.println(wow.dayOfWeek());
            System.out.println(wow.dayOfWeekHuman());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
