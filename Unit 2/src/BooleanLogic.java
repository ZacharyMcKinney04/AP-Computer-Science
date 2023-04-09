public class BooleanLogic {
    public static void main(String[] args){
        unitTestIsThirteen();
    }

    public static boolean isLeapYear(int year){
        int leapFour = 4;
        int leapHundred = 100;
        int leapFourHundred = 400;
        if (year <= 0){
            return false;
        } else{
        return ( ( year % leapFour == 0 ) && !((year%leapHundred) == 0) || (year % leapFourHundred == 0));
        }
    }

    public static boolean isThirteen(int month, int day, int year){
        int requirementLimit = 0; // 0 meaning equal. less meaning older
        int requiredYear = 13;
        int currentYear = 2022;
        int currentMonth = 9;
        int currentDay = 20;
        boolean inYearCurrent = ((currentYear - year) == requiredYear);
        boolean inMonthCurrent = (currentMonth == month);
        boolean inDayCurrent = currentDay == day; 
        // System.out.println("This is a leap year? " + isLeapYear(year));
        if((currentYear - year) > requiredYear){
            return true;
        } else if (((currentMonth - month) > requirementLimit ) && (inYearCurrent)){
            return true;
        } else if ( ((currentDay - day) > requirementLimit) && (inMonthCurrent )&& (inYearCurrent)){
            return true;
        } else {
            return (inDayCurrent && inMonthCurrent && inYearCurrent);
        }
    }

    public static void unitTestIsThirteen() {
        // input current month, day, year here
        final int DAY = 20;
        final int MONTH = 9;
        final int YEAR = 2022;
        System.out.println("Do the actual and expected results match?");
        // actual result expected result
        System.out.println("Birthday in next year:");
        System.out.print(">m >d >y: ");
        System.out.println(isThirteen(MONTH + 1, DAY + 1, YEAR - 12) == false);
        System.out.print(" <m >d >y: ");
        System.out.println(isThirteen(MONTH - 1, DAY + 1, YEAR - 12) == false);
        System.out.print(" =m >d >y: ");
        System.out.println(isThirteen(MONTH, DAY + 1, YEAR - 12) == false);

        System.out.print(" >m <d >y: ");
        System.out.println(isThirteen(MONTH + 1, DAY - 1, YEAR - 12) == false);
        System.out.print(" <m <d >y: ");
        System.out.println(isThirteen(MONTH - 1, DAY - 1, YEAR - 12) == false);
        System.out.print(" =m <d >y: ");
        System.out.println(isThirteen(MONTH, DAY - 1, YEAR - 12) == false);

        System.out.print(" >m =d >y: ");
        System.out.println(isThirteen(MONTH + 1, DAY, YEAR - 12) == false);
        System.out.print(" <m =d >y: ");
        System.out.println(isThirteen(MONTH - 1, DAY, YEAR - 12) == false);
        System.out.print(" =m =d >y: ");
        System.out.println(isThirteen(MONTH, DAY, YEAR - 12) == false);

        System.out.println("Birthday in previous year:");
        System.out.print(" >m >d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY + 1, YEAR - 14) == true);
        System.out.print(" <m >d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY + 1, YEAR - 14) == true);
        System.out.print(" =m >d <y: ");
        System.out.println(isThirteen(MONTH, DAY + 1, YEAR - 14) == true);

        System.out.print(" >m <d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY - 1, YEAR - 14) == true);
        System.out.print(" <m <d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY - 1, YEAR - 14) == true);
        System.out.print(" =m <d <y: ");
        System.out.println(isThirteen(MONTH, DAY - 1, YEAR - 14) == true);

        System.out.print(" >m =d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY, YEAR - 14) == true);
        System.out.print(" <m =d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY, YEAR - 14) == true);
        System.out.print(" =m =d <y: ");
        System.out.println(isThirteen(MONTH, DAY, YEAR - 14) == true);

        System.out.println("Birthday in this year:");
        System.out.print(" >m >d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY + 1, YEAR - 13) == false);
        System.out.print(" <m >d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY + 1, YEAR - 13) == true);
        System.out.print(" =m >d <y: ");
        System.out.println(isThirteen(MONTH, DAY + 1, YEAR - 13) == false);

        System.out.print(" >m <d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY - 1, YEAR - 13) == false);
        System.out.print(" <m <d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY - 1, YEAR - 13) == true);
        System.out.print(" =m <d <y: ");
        System.out.println(isThirteen(MONTH, DAY - 1, YEAR - 13) == true);

        System.out.print(" >m =d <y: ");
        System.out.println(isThirteen(MONTH + 1, DAY, YEAR - 13) == false);
        System.out.print(" <m =d <y: ");
        System.out.println(isThirteen(MONTH - 1, DAY, YEAR - 13) == true);
        System.out.print(" =m =d <y: ");
        System.out.println(isThirteen(MONTH, DAY, YEAR - 13) == true);

    }

}
