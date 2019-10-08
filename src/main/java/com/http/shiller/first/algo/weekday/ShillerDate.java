package com.http.shiller.first.algo.weekday;

public class ShillerDate implements Comparable<ShillerDate> {

    //01.01.2018 - Monday

    int dayNumber;
    int monthNumber;
    int yearNumber;

    public enum WeekDays{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    public ShillerDate(int dayNumber, int monthNumber, int yearNumber) throws Exception {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (yearNumber < 1) {
            throw new Exception(String.format("Incorrect date: %d-%d-%d", yearNumber, monthNumber, dayNumber));
        }
        if (monthNumber > 12 || monthNumber < 1) {
            throw new Exception(String.format("Incorrect date: %d-%d-%d", yearNumber, monthNumber, dayNumber));
        }
        if (dayNumber < 1) {
            throw new Exception(String.format("Incorrect date: %d-%d-%d", yearNumber, monthNumber, dayNumber));
        }
        if (monthNumber == 2) {
            boolean isLeap = ((yearNumber % 4 == 0) && (yearNumber % 100 != 0)) || (yearNumber % 400 == 0);
            if (dayNumber > daysInMonths[monthNumber - 1] + (isLeap ? 1 : 0)) {
                throw new Exception(String.format("Incorrect date: %d-%d-%d", yearNumber, monthNumber, dayNumber));
            }
        }
        if (dayNumber > daysInMonths[monthNumber - 1]) {
            throw new Exception(String.format("Incorrect date: %d-%d-%d", yearNumber, monthNumber, dayNumber));
        }

        this.dayNumber = dayNumber;
        this.monthNumber = monthNumber;
        this.yearNumber = yearNumber;
    }

    public boolean isInLeapYear() {
        return ((this.yearNumber % 4 == 0) && (this.yearNumber % 100 != 0)) || (this.yearNumber % 400 == 0);
    }

    public int yearsTillNextLeapYear() throws Exception {
        if (isInLeapYear()) {
            return 0;
        }
        int i = 0;
        do {
            i++;
        } while (!new ShillerDate(1, 1, this.yearNumber + i).isInLeapYear());
        return i;
    }

    public int yearsFromPreviousLeapYear() throws Exception {
        if (isInLeapYear()) {
            return 0;
        }
        int i = 0;
        do {
            i++;
        } while (!new ShillerDate(1, 1, this.yearNumber - i).isInLeapYear());
        return i;
    }

    public int daysCountInYear() {
        return isInLeapYear() ? 366 : 365;
    }

    public int daysCountInMonth() {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (this.monthNumber == 2) {
            return daysInMonths[this.monthNumber - 1] + (isInLeapYear() ? 1 : 0);
        }
        return daysInMonths[this.monthNumber - 1];
    }

    public void addDays(int days) {

        if (days < 0) {
            removeDays(-1 * days);
        }

        int daysLeft = days;


        int deltaDays = daysLeft - daysTillEndOfMonth();



        while (deltaDays > 0) {
            if (this.monthNumber == 12) {
                this.yearNumber++;
                this.monthNumber = 1;
            } else {
                this.monthNumber++;
            }
            this.dayNumber = 1;
            daysLeft = deltaDays;
            deltaDays = daysLeft - daysTillEndOfMonth() - 1;
        }

        if (deltaDays <= 0) {
            this.dayNumber += daysLeft - 1;
        }
    }

    public void removeDays(int days) {

        if (days < 0) {
            addDays(-1 * days);
        }

        int daysLeft = days;

        int deltaDays = daysLeft - daysFromBeginOfMonth();

        while (deltaDays > 0) {
            if (this.monthNumber == 1) {
                this.yearNumber--;
                this.monthNumber = 12;
            } else {
                this.monthNumber--;
            }
            this.dayNumber = daysCountInMonth();
            daysLeft = deltaDays;
            deltaDays = daysLeft - daysFromBeginOfMonth();
        }

        if (deltaDays <= 0) {
            this.dayNumber -= daysLeft;
        }
    }

    public int daysToDate(ShillerDate date) throws Exception {
        int compare = compareTo(date);
        int sign = 1;
        ShillerDate date1;
        ShillerDate date2;
        if (compare == 0) {
            return 0;
        }
        if (compare > 0) {
            sign = -1;
            date1 = new ShillerDate(date.dayNumber, date.monthNumber, date.yearNumber);
            date2 = new ShillerDate(this.dayNumber, this.monthNumber, this.yearNumber);
        } else {
            date1 = new ShillerDate(this.dayNumber, this.monthNumber, this.yearNumber);
            date2 = new ShillerDate(date.dayNumber, date.monthNumber, date.yearNumber);
        }

        int resultDays = 0;
        if (date1.yearNumber == date2.yearNumber) {
            //same year
            if (date1.monthNumber == date2.monthNumber) {
                //same month
                resultDays += (date2.dayNumber - date1.dayNumber);
            } else {
                resultDays += date1.daysTillEndOfMonth();
                resultDays += date2.daysFromBeginOfMonth();

                for (int i = date1.monthNumber + 1; i < date2.monthNumber; i++) {
                    resultDays += new ShillerDate(1, i, date2.yearNumber).daysCountInMonth();
                }
            }

        } else {
            resultDays += date1.daysTillEndOfYear();
            resultDays += date2.daysFromBeginOfYear();

            for (int i = date1.yearNumber + 1; i < date2.yearNumber; i++) {
                resultDays += new ShillerDate(1, 1, i).daysCountInYear();
            }
        }
        return sign * resultDays;
    }

    public int daysTillEndOfMonth() {
        return daysCountInMonth() - this.dayNumber;
    }

    public int daysFromBeginOfMonth() {
        return this.dayNumber;
    }

    public int daysTillEndOfYear() {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysCount = 0;
        for (int i = this.monthNumber + 1; i <= 12; i++) {
            daysCount += daysInMonths[i - 1];
            if (i == 2 && isInLeapYear()) {
                daysCount += 1;
            }
        }
        return daysCount + daysTillEndOfMonth();
    }

    public int daysFromBeginOfYear() {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysCount = 0;
        for (int i = 1; i < this.monthNumber; i++) {
            daysCount += daysInMonths[i - 1];
            if (i == 2 && isInLeapYear()) {
                daysCount += 1;
            }
        }
        return daysCount + daysFromBeginOfMonth();
    }

    public int dayOfWeek() throws Exception {
        int offset = daysToDate(new ShillerDate(1,1,2018));
        int nonFullWeekDays = -1 * (offset % 7);
        if (nonFullWeekDays >= 0) {
            return 1 + nonFullWeekDays;
        } else {
            return 8 + nonFullWeekDays;
        }
    }

    public String dayOfWeekHuman() throws Exception {
        int result = dayOfWeek();
        switch(result) {
            case 1: return WeekDays.MONDAY.name();
            case 2: return WeekDays.TUESDAY.name();
            case 3: return WeekDays.WEDNESDAY.name();
            case 4: return WeekDays.THURSDAY.name();
            case 5: return WeekDays.FRIDAY.name();
            case 6: return WeekDays.SATURDAY.name();
            case 7: return WeekDays.SUNDAY.name();
            default: return "Oops... UFO came and left this here..." + " (" + result + ")";
        }
    }


    @Override
    public String toString() {
        return String.format("%d-%d-%d", this.yearNumber, this.monthNumber, this.dayNumber);
    }

    @Override
    public int compareTo(ShillerDate date) {
        if (this.yearNumber < date.yearNumber) {
            return -1;
        } else {
            if (this.yearNumber > date.yearNumber) {
                return 1;
            } else {
                if (this.monthNumber < date.monthNumber) {
                    return -2;
                } else {
                    if (this.monthNumber > date.monthNumber) {
                        return 2;
                    } else {
                        if (this.dayNumber < date.dayNumber) {
                            return -3;
                        } else {
                            if (this.dayNumber > date.dayNumber) {
                                return 3;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }
}
