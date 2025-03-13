import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class test {

    public static void main(String[] args) {
       

        MathContext depth = new MathContext(100000000);

        BigDecimal a = new BigDecimal(3, depth);
        BigDecimal b = BigDecimal.valueOf(10);

        BigDecimal c = b.divide(a, depth);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);



    }
}
