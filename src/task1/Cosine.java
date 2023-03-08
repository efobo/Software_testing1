package task1;

//Java Program to Implement the cos() Function(approximately)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Cosine {

    private Cosine() {}
    // Function to read user input and calculate the cosine of the angle
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x;
        try {
            System.out.println("Enter the angle whose cosine is to be calculated in degrees");
            x = Double.parseDouble(br.readLine());
        } catch (Exception e) {
            System.out.println("An error occurred");
            return;
        }


        double cosine = Cosine(x);



        System.out.format("The cosine of " + x + " is %f",cosine);
    }

    public static double Cosine(double x) {

        x = transformationX(x);
        x = Math.toRadians(x);

        int numTerms = 10;
        double cosine = 0D;
        for (int i = 0; i < numTerms; i++) {
            cosine += (i%2 == 0 ? 1 : -1) * calculateTerm(x, 2*i);
        }

        if (cosine == 0) {
            cosine = Math.abs(cosine);
        }

        return cosine;
    }

    private static double transformationX (double x) {
        x = Math.abs(x);
        while ((x-360) > 0) {
            x -=  360;
        }
        System.out.println(x);
        return x;
    }

    private static double calculateTerm(double x, int numTerms)
    {
        double term = 1D;
        for (int i = numTerms; i > 0; i--) {
            term *= x/i;
        }
        return term;
    }





}
