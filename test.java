import java.util.*;

public class test {
    public static void main(String[] args) {
        List<String> x = new ArrayList<>();
        x.add("1");

        System.out.println(Long.valueOf(1) == 1);
        System.out.println(x.toString().substring(1, x.toString().length()-1));

        List y = new ArrayList<>();
        y.add("a");
        y.add(1);
        System.out.println(y);

        System.out.println(Double.valueOf(0) == 0);

        String foo = y.get(0).toString();

        y.set(0, "b");
        System.out.println(foo);
    }
}
