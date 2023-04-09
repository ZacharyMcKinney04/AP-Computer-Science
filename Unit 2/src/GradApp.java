public class GradApp {
    public static void main(String[] args){
        double totalCred = 25;
        double yearEng = 4;
        double yearMath = 5;
        boolean hasEco = true;
        boolean hasGov = true;
        System.out.println(canGraduate(totalCred, yearEng, yearMath, hasEco, hasGov));
    }

    public static boolean canGraduate(double totalCred, double yearEng, double yearMath, boolean hasEco, boolean hasGov){
        boolean creditLevels = (totalCred >= 24 && yearMath >= 3 && yearEng >= 4);
        boolean reqdCourses = (hasEco && hasGov);     
        return (creditLevels && reqdCourses);
    }
}
