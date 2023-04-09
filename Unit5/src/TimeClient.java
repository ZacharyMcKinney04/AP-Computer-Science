public class TimeClient {
    public static void main(String[] args) {
        Time start = new Time(3, 30, 34);
        Time duration = new Time(1, 20, 10);
        Time clone = new Time(1, 20, 10);
        Time fake = new Time(1, 20, 15);
        Time endTime = start.add(duration);
        
        System.out.println(endTime.toString());
        System.out.println(clone.equals(fake));
        start = new Time(1, 20, 10);
        System.out.println(clone.equals(start));
        System.out.println(clone.compareTo(fake));
        System.out.println();
        
        start = new Time(3, 30, 34);
        duration = new Time(1, 20, 10);
        System.out.println(duration.subtract(start));
        System.out.println(start.subtract(duration));

        // becuase of information hidining, internal changes to a 
        // class are invisible
    }

}
