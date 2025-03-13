import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;

public class PI_DAY {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void save(BigDecimal output, String name) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(name, "UTF-8");

        writer.write(output.toPlainString());

    }

    public static List<BigDecimal> chudify (BigDecimal a, BigDecimal b, MathContext depth) {
        
        BigDecimal Pab = (a.multiply(BigDecimal.valueOf(6), depth).subtract(BigDecimal.valueOf(5), depth)).multiply(a.multiply(BigDecimal.valueOf(2), depth).subtract(BigDecimal.valueOf(1), depth), depth).multiply(a.multiply(BigDecimal.valueOf(6), depth).subtract(BigDecimal.valueOf(1), depth), depth);
        
        BigDecimal Qab = a.pow(3, depth).multiply(BigDecimal.valueOf(10939058860032000l), depth);
        
        BigDecimal Rab = Pab.multiply(a.multiply(BigDecimal.valueOf(545140134), depth).add(BigDecimal.valueOf(13591409), depth), depth);

        List<BigDecimal> output = new ArrayList<>();
        output.add(Pab);
        output.add(Qab);
        output.add(Rab);
        return output;

    }
    
    public static List<BigDecimal> chudnovskify (BigDecimal a, BigDecimal b, MathContext depth) {

        BigDecimal Pab;
        BigDecimal Qab;
        BigDecimal Rab;

        BigDecimal m = a.add(b, depth);
        List<BigDecimal> a_set = chudify(a, m, depth);
        List<BigDecimal> b_set = chudify(m, b, depth);
        
        BigDecimal Pam = a_set.get(0);
        BigDecimal Qam = a_set.get(1);
        BigDecimal Ram = a_set.get(2);

        BigDecimal Pmb = b_set.get(0);
        BigDecimal Qmb = b_set.get(1);
        BigDecimal Rmb = b_set.get(2);

        Pab = Pam.multiply(Pmb, depth);
        Qab = Qam.multiply(Qmb, depth);
        Rab = Qmb.multiply(Ram, depth).add(Pam.multiply(Rmb, depth), depth);

        List<BigDecimal> output = new ArrayList<>();

        output.add(Pab);
        output.add(Qab);
        output.add(Rab);
        return output;

    }

    public static BigDecimal chudnovsky(BigDecimal n, MathContext depth) {

        // Chudnovsky algorithm
        List<BigDecimal> chuds = chudnovskify(BigDecimal.valueOf(1), n, depth);
        // BigDecimal P1n = chuds.get(0);
        BigDecimal Q1n = chuds.get(1);
        BigDecimal R1n = chuds.get(2);
        return (BigDecimal.valueOf(426880).multiply(BigDecimal.valueOf(10005).sqrt(depth), depth).multiply(Q1n, depth).divide(Q1n.multiply(BigDecimal.valueOf(13591409), depth).add(R1n, depth), depth));

    }
    public static void main(String[] args) throws IOException {


        // get the number of digits
        System.out.println("How many million digits?");
        String input = reader.readLine();

        // time the calculation
        long start = System.currentTimeMillis();

        int mdigits = Integer.parseInt(input) * 1000000;

        // set the number of digits
        MathContext depth = new MathContext(mdigits);
        BigDecimal n = new BigDecimal(mdigits, depth);

        // calculate PI
        BigDecimal PI = chudnovsky(n, depth);

        System.out.println("Time to calculate: " + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();

        // save the result
        save(PI, "PI"+input+"M.txt");

        System.out.println("Time to save: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("Finished.");
        //System.out.println(PI);

    }
    
}
