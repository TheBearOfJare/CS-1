import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Long;

public class higherLower {
    
    // generate a random number
    
    public static long getNewRandomInt() {

        double r = Math.random()*10;
        long output =  Math.round(r);
        return output;
    }


    public static void main(String[] args) throws IOException {

        long number = getNewRandomInt();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("I'm thinking of a number from 0-10 (inclusive). Try to guess it :)");
        //System.out.println(number);

        while (true) {

            System.out.println("\n");

            String guess = reader.readLine();
    
            // send the "you win" message
            if (guess.equals(number+"")) {
                
                System.out.println("Nice work! You guessed it!");
                break;
    
            }

            // send the "you lost" message
            else {
    
                
                try {
                    long guessNum = Long.parseLong(guess);

                    if (guessNum < number) {
                        System.out.println("Higher...");

                    }
                    else {
                        System.out.println("Lower...");
                    }
                } catch (Exception e) {
                    // the guess straight up isn't a number
    
                    System.out.println("That's not even a number");
                    break;
                }
    
            }
        }
        
        
        

        


    }

}
