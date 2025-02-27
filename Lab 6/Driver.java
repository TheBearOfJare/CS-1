import java.io.*;

public class Driver {
    
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        System.out.println("Enter a number: ");

        String input = reader.readLine();

        String OctalValue = Integer.toOctalString(Integer.parseInt(input));

        System.out.println("Your number in Octal: " + OctalValue);

        String HexValue = (Integer.toHexString(Integer.parseInt(input)));

        System.out.println("Your number in Hex: " + HexValue);

        System.out.println("Your number in binary: " + Integer.toBinaryString(Integer.parseInt(input)));


        String binaryVal = Integer.toBinaryString(Integer.parseInt(input));

        for (int i = 0; i < binaryVal.length(); i++) {

            if (binaryVal.substring(i, i+1).equals("1")) {

                System.out.println("Index of first 1 in string: " + i);
                break;
            }

        }

        // last 1


        for (int i = binaryVal.length(); i >= 0; i--) {

            //System.out.println(binaryVal.substring(i, i+1));

            if (binaryVal.substring(i-1, i).equals("1")) {

                System.out.println("Index of last 1 in string: " + (i-1));
                break;
            }

        }

        System.out.println("Enter an Octal number: ");

        input = reader.readLine();

        int deciVal = Integer.parseInt(input, 8);

        System.out.println("Your Octal number in decimal: " + deciVal);

        // Hex part

        System.out.println("Enter a Hex number: ");

        input = reader.readLine();

        deciVal = Integer.parseInt(input, 16);

        System.out.println("Your Hex number in decimal: " + deciVal);





    }
    

}
