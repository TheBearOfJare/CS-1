import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int length;
        int sharpness;
        int cut;


        System.out.println("Enter a length: ");

        length = Integer.parseInt(reader.readLine());

        Paper paper = new Paper(length);


        System.out.println("Enter a sharpness: ");

        sharpness = Integer.parseInt(reader.readLine());

        Scissors scissors = new Scissors(sharpness);


        System.out.println("Enter a length for the cut: ");

        cut = Integer.parseInt(reader.readLine());

        scissors.cutPaper(paper, cut);

        paper.printInformation();


    }


}
