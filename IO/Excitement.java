import java.io.*;

public class Excitement {
    
    public static final void main(String[] args) {
        try {
            System.setErr(new PrintStream(new BufferedOutputStream(new FileOutputStream("Error Log.txt"))));
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace(System.err);
            
        }
        PrintWriter writer = null;
        BufferedReader reader = null;

        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("Test.txt")));
            reader = new BufferedReader(new FileReader("NoExcitement.java"))

            String input = null;
            while((input = reader.readLine()) != null) {
                writer.println(input);
            }

            writer.flush();
            writer.close();
        }
        catch(FileNotFoundException fnfe) {
            
        }
        catch(IOException e){

        } finally {
            try {
                writer.close();
            } catch(Exception e){}
            try {
                reader.close();
            }
            catch (Exception e){}
        }

        try {
            errorOut.close();
        }
        catch (Exception e){}
        finally {
            
        }
    }

}
