import java.time.Duration;
import java.time.Instant;

public class overflow {


    public static final void main(String[] args) {
        var time = Instant.now();
        int x = (short)1;

        while ((short)x != 0) {
            x++;
            System.out.println((short)x+"\r");
        }
        var end = Instant.now();
        System.out.print("Back to 0 in: ");
        System.out.print(Duration.between(time,end).toString().substring(2,Duration.between(time,end).toString().length()-1));
        System.out.println("s");
    }
    
}