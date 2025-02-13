import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.*;

public class TypingTest {

    public static void main(String[] args) throws Exception
    {
        
        String path = "emma.txt";

        BufferedReader bfro = new BufferedReader(new FileReader(path));

        String st;

        List<String> fullText = new ArrayList<>();
        while ((st = bfro.readLine()) != null) {
            fullText.add(st);
        }


        //System.out.println(fullText);

        //System.out.println(fullText.get(0));

        int randIndex = Math.toIntExact(Math.round(Math.random()*(fullText.size()-7)));
        String selection = "";
        for (int i=randIndex; i<randIndex+3; i++) {
            selection += fullText.get(i) + " ";
        }

        int firstQuote = selection.indexOf("\"");
        int firstPeriod = selection.indexOf(".");
        int firstQuestion = selection.indexOf("?");
        int firstEx = selection.indexOf("!");


        System.out.println(selection);
            
    }
}