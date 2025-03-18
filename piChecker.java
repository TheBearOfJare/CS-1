import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class piChecker {

    public static String readFile(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            StringBuilder contents = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                contents.append(line);
            }
            reader.close();
            return contents.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        
        // read PI_ACTUAL.txt
        String pi = readFile("PI_ACTUAL.txt");
        String pi_calculated = readFile("PI_0.1M.txt");

        for (int i = 0; i < pi_calculated.length(); i++) {
            if (!pi_calculated.substring(i, i+1).equals(pi.substring(i, i+1))) {
                System.out.println("Correct until: " + i);
                break;
            }
        }
        
    }
}
