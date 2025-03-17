import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;


public class test {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        MathContext mc = new MathContext(100000);

        long start = System.currentTimeMillis();
        BigDecimal a = new BigDecimal(10d);
        BigDecimal b = new BigDecimal(3d);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(b);


    }
}
