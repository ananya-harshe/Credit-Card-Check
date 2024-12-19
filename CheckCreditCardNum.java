/**
 * This program can take in a credit card number and use the last digit to check if it is valid.
 *
 * @author Ananya Harshe
 * @version 8/5/2023
 */
import java.util.Scanner;
import java.math.BigInteger;
public class CheckCreditCardNum

{
    public static boolean checkNum(String creditCardNum)
    {
        //taking out the check digit
        int sum = 0;
        BigInteger ccm = new BigInteger(creditCardNum);
        BigInteger checkDigit = ccm.mod(BigInteger.TEN);
        ccm = ccm.divide(BigInteger.TEN);
        String digit = "";
        int dig;

        for(int i = creditCardNum.length() - 1; i >= 0; i--)
        {
            digit = creditCardNum.substring(i, i + 1);
            dig = Integer.parseInt(digit);
            if ((creditCardNum.length() - i) % 2== 1) {
                dig *= 2;
                if(dig > 9) 
                    dig -= 9;
            }
            sum += dig;
        }

        int mod = sum % 10;
        //Integer intMod = Integer.valueOf(mod);
        //BigInteger bigMod = BigInteger.valueOf(mod.valueOf(intMod));
        BigInteger modCheck = BigInteger.valueOf(mod == 0 ? 0 : 10 - mod);

        if (modCheck == checkDigit)
            return true;
        else
            return false;
    }

    public static void main (String[]args)
    {
        //take in data
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your credit card number: ");
        String creditCardNum = in.next();

        while (creditCardNum.length() != 16 || !creditCardNum.matches("\\d+"))
        {
            System.out.println("Please enter a valid 16-digit credit card.");
            System.out.print("Please enter your credit card number: ");
            creditCardNum = in.next();
        }

        /*for(int i = 0; i < creditCardNum.length(); i++)
        {
            if(Character.isDigit(creditCardNum.charAt(i)) == false)
                System.out.println("Please enter a proper credit card number.\n");

            System.out.print("Please enter your credit card number: ");
            creditCardNum = in.next();
        }*/

        boolean isValid = checkNum(creditCardNum);

        if(isValid == true)
            System.out.print("This credit card number is valid.");
        else
            System.out.print("This credit card number is not valid."); 
    }
}
