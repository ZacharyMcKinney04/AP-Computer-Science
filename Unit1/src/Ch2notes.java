public class Ch2notes {
    public static void main(String[] args) throws Exception {
        byte a;          //declaration statement
        a=-128;          // assignment statement
        short b = 32767; //initialization is delcare and assignment
        b += 5;          //overflow - the number suddenly goes very negative
        int x, y, z;     // multiple declaration that you should avoid 
        x=1;
        y=2;
        z=3;
        int p=1; int q =2; int r = 3; // never do this 
        int f = 2; 
        int g = 10;
        int h = -2;
        g = h;
        f = f + 1;
        System.out.println(a);
        System.out.println(b+2);
        System.out.println(x + y + z + p + q + r + g);
        //'cast' one type of variable to another
        //in this case, to get flaoting point division
        double result = (double) 10 / 4;
        System.out.println(result);
        // example of loss of precision with floating point variables
        double noodle = 0.1;
        double pasta = noodle + noodle + noodle;
        System.out.println(pasta);

        //string var - note capital S and double quotes
        String m = "a";
        // char var - note lowercase c and single quotes
        char n = 'a';
        System.out.println(n + m);
        n=5063;
        System.out.println(n);


    }
}
    