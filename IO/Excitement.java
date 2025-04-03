import java.io.*;

public class Excitement {
    
    public static final void main(String[] args) {
        PrintWriter writer = null;
        BufferedReader reader = null;

        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("Test.txt")));
            reader = new BufferedReader(new FileReader("Excitement.java"))
            writer.println("Test");
            writer.flush();
        }
        catch (IOException e){

        } finally {
            try {
                writer.close();
            } catch(Exception e){}
        }
    }

}
