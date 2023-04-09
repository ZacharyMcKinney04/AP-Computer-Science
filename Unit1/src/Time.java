public class Time {
    public static void main(String[] args) throws Exception {
        
        long codeStart = System.nanoTime();
        
        //initial time and variables
        int hour = 11;
        int minute = 47;
        int second = 11;
        int timeInADay = 24*60*60;  //total seconds in a day
        int secondsSinceMidnight = hour*60*60+minute*60+second; // total seconds of the day so far  
        
        // float conversion
        float secondsTotalFloat = secondsSinceMidnight;
        float timeInADayFloat = timeInADay;     
        float dayPercent = (secondsTotalFloat/timeInADayFloat);  
        
        System.out.println("The time since midnight is " + secondsSinceMidnight + " seconds."); //midnight teller
        System.out.print("The time remaining today is "); //time remaining
        System.out.println(timeInADay-hour*60*60-minute*60-second + " seconds.");
        System.out.print("The percentage of passed for today is "); //percentage of day
        System.out.println(dayPercent*100 + "%.");

        int startTime = secondsSinceMidnight;
        hour = 14;
        minute = 27;
        second = 45;
        secondsSinceMidnight = hour * 3600 + minute * 60 +second;
        int elapsedTime  =secondsSinceMidnight - startTime;
        System.out.println("Elapsed time since start:" + elapsedTime);

        long codeEnd = System.nanoTime();
        System.out.println("Code time = " + (codeEnd - codeStart));
    }
}