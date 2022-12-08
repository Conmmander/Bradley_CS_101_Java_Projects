import java.util.Scanner;

public class RomanNumeralCalculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num;

        do
        {
            System.out.println("Please enter an integer from 1 to 5999. Enter a negative number or zero to exit."); // Added "or zero" to string, since it supports 0, and there is no representation of 0 in roman numerals.
            System.out.print("-> ");
            num = input.nextInt(); // I assume we expect that only numbers will be input.

            if (num <= 0) System.exit(0);

            if (num < 6000)
            {
                String roman = "";

                while (num >= 1000)
                {
                    roman += "M";
                    num -= 1000;
                }

                switch ((num / 100) ) // Checks 100's places
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        roman += "CD";
                        num -= 400;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    	roman += "D";
                        num -= 500;
                        break;
                    case 9:
                        roman += "CM";
                        num -= 900;
                        break;
                    default:
                        System.err.println("There is a problem with the hundreds place."); // Fixed wording, because this deals with hundreds place values
                }

                while (num >= 100)
                {
                    roman += "C";
                    num -= 100;
                }
                
                switch ((num / 10) % 10) // Added parenthesis to make more readable.
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        roman += "XL";
                        num -= 40;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        roman += "L";
                        num -= 50;
                        break;
                    case 9:
                        roman += "XC"; // Should be XC, not CS. This locates 90 and converts it.
                        num -= 90;
                        break;
                    default:
                        System.err.println("There is a problem with the tens place.");
                }

                while (num >= 10)
                {
                    roman += "X";
                    num -= 10;
                }

                switch (num)
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        roman += "IV";
                        num -= 4;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        roman += "V"; // While not an error in and of itself, capitalized the V to match roman numerals.
                        num -= 5;
                        break;
                    case 9:
                        roman += "IX";
                        num -= 9;
                        break;

                    default:
                        System.err.println("There is a problem with the ones place."); // Fixed unit identification
                }

                while (num > 0)
                {
                    roman += "I";
                    num--;
                }

                System.out.println(roman);
            }
        }
        while (true); // Converted to a true loop, so that it will continue to run. Otherwise will not run properly.
    }
}
