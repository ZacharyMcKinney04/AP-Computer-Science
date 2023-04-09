import java.util.Scanner;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;

@SuppressWarnings("resource")
public class Receipt {
    public static void main(String[] args) throws Exception{
        //String date = ZonedDateTime.now(ZoneId.of("America/Chicago")).format(DateTimeFormatter.ofPattern("MM/dd/uuuu\nHH:mm:ss"));
        final double FOOD_TAX = 1.01;
        final double COMMON_TAX = 1.0875;
        double foodCost;
        double foodCostTax;
        double nonFoodCost;
        double nonFoodCostTax;
        double totalCost;
        double totalCostTax;
        Scanner in = new Scanner(System.in);

        //my grocery
        System.out.print("How much did you pay for in food items? ");
        foodCost = in.nextDouble();
        foodCostTax = foodCost * FOOD_TAX;
        System.out.print("How much was everything else? ");
        nonFoodCost = in.nextDouble();
        nonFoodCostTax = nonFoodCost * COMMON_TAX;
        totalCost = foodCost + nonFoodCost ;
        totalCostTax = foodCostTax + nonFoodCostTax;

        //System.out.println(date);
        System.out.printf("Cost of food: $%.2f \n", foodCost);
        System.out.printf("Cost of non-food items: $%.2f \n", nonFoodCost);
        System.out.printf("Total cost  of purchase: $%.2f \n", totalCost);
        System.out.printf("Cost of  food items w/ tax: $%.2f \n", foodCostTax);
        System.out.printf("Cost of of non-food items w/ tax: $%.2f \n", nonFoodCostTax);
        System.out.printf("Total cost of purchase w/ tax: $%.2f \n", totalCostTax);

    }

    
}