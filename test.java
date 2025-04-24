import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;


public class test {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        int[] a = new int[5];

        // System.out.println(a.length);

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*100);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        int p = 1;
        p *= 4;
        System.out.println(p);

    }
}
