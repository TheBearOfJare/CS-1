import java.time.Duration;
import java.time.Instant;

public class EfficiencyComparison {
    
    public static void main(String[] args) {
        var time = Instant.now();
        int x = 0;
        int y = 9;
        while (x<1000000000) {
            x++;
            y = x;
        }
        
        var end = Instant.now();
        System.out.print("Did it with two lines in: ");
        System.out.print(Duration.between(time,end).toString().substring(2,Duration.between(time,end).toString().length()-1));
        System.out.println("s");

        time = Instant.now();
        int n = 0;
        int i = 9;

        while (n < 1000000000) {
            i = ++n;
        }
        

        end = Instant.now();
        System.out.print("Did it with one line in: ");
        System.out.print(Duration.between(time,end).toString().substring(2,Duration.between(time,end).toString().length()-1));
        System.out.println("s");
    }
}
