import java.util.*;;

public class PI_DAY {

    public static List<Double> chudify (int a, int b) {
        
        double Pab = -(6*a - 5)*(2*a - 1)*(6*a - 1);
        double Qab = 10939058860032000d * Math.pow(a, 3);
        double Rab = Pab * (545140134*a + 13591409);

        List<Double> output = new ArrayList<>();
        output.add(Pab);
        output.add(Qab);
        output.add(Rab);
        return output;

    }
    
    public static List<Double> chudnovskify (int a, int b) {

        double Pab;
        double Qab;
        double Rab;

        if (b == a + 1) {
            Pab = -(6*a - 5)*(2*a - 1)*(6*a - 1);
            Qab = 10939058860032000d * Math.pow(a, 3);
            Rab = Pab * (545140134*a + 13591409);

        }
        else {
            int m = a + b;
            List<Double> a_set = chudify(a, m);
            List<Double> b_set = chudify(m, b);
            
            double Pam = a_set.get(0);
            double Qam = a_set.get(1);
            double Ram = a_set.get(2);

            double Pmb = b_set.get(0);
            double Qmb = b_set.get(1);
            double Rmb = b_set.get(2);

            Pab = Pam * Pmb;
            Qab = Qam * Qmb;
            Rab = Qmb * Ram + Pam * Rmb;
        }

        List<Double> output = new ArrayList<>();

        output.add(Pab);
        output.add(Qab);
        output.add(Rab);
        return output;

    }

    public static double chudnovsky(int n) {
        // Chudnovsky algorithm.
        List<Double> chuds = chudnovskify(1, n);
        double P1n = chuds.get(0);
        double Q1n = chuds.get(1);
        double R1n = chuds.get(2);
        return (426880 * Math.sqrt(10005) * Q1n) / (13591409*Q1n + R1n);

    }
    public static void main(String[] args) {

        int depth = 100;
        System.out.println(depth + " " + chudnovsky(depth));  // 3.141592653589793238462643384

        // for (int n = 1; n < 10; n++) {
        //     System.out.println("{n} = " + chudnovsky(n));  // 3.14159265358979323846264338...
        // }

    }
    
}
