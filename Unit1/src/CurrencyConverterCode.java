import java.util.Scanner;
@SuppressWarnings("resource")
public class CurrencyConverterCode {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        final double USD_TO_EURO = .84; // 1 USD to blank ratio money
        final double USD_TO_GBP = .78;
        final int USD_TO_KNUTS = 100;
        final int KNUTS_IN_GALLEON = 493 ; // 1 galleon for 493 knuts
        final int KNUTS_IN_SICKLE = 29; // 29 KNUTS = 1 SICKLE
        double inputDollar; 
        double outputEuro;
        double outputGBP;
        int outputKnuts;
        int inputKnutsTotal;
        int outputSickle;
        int outputGalleon;

        //user input and conversion
        System.out.print("How many dollars in USD do you have? ");
        inputDollar = in.nextDouble();
        outputEuro = USD_TO_EURO * inputDollar;
        outputGBP = USD_TO_GBP * inputDollar;
        inputKnutsTotal = (int) (USD_TO_KNUTS * inputDollar);
        outputGalleon = (inputKnutsTotal / KNUTS_IN_GALLEON);
        outputSickle = ((inputKnutsTotal % KNUTS_IN_GALLEON) / KNUTS_IN_SICKLE);
        outputKnuts = ((inputKnutsTotal % KNUTS_IN_GALLEON) % KNUTS_IN_SICKLE);

        //Text outputs of userDollar
        System.out.printf("USD Converted:                $%4.2f \n", inputDollar);
        System.out.printf("USD to Euros:                  %4.2f \n", outputEuro);
        System.out.printf("USD to Great British Pounds:   %4.2f \n", outputGBP);
        System.out.printf("USD to Harry Potter Money:     %4d Galleons", outputGalleon);  
        System.out.printf("%d Sickles, and %d Knuts. \n", outputSickle, outputKnuts);  
    }

    
}