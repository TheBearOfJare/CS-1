public class Driver {
    public static void main(String[] args) {

        int length = 42;

        int[] a = new int[length];

        // System.out.println(a.length);

        for (int i = 0; i < a.length; i++) {
            if ((i+1)%5 == 0) {
                a[i] = i*5;
            }
            else {
                a[i] = i;
            }
        }

        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                System.out.print(a[i] + ", ");
            }
            else {
                System.out.print(a[i]+ "]\n");
            }
            
        }


        // array of classes

        Chaos[] chaos = new Chaos[42];

        for(int i = chaos.length-1; i >= 0; i--) {
            chaos[i] = new Chaos((i%2 == 0), (int)(Math.random()*100));
        }

        for (int i = 0; i < chaos.length; i++) {
            chaos[i].printDeath();
            chaos[i].printPennies();
        }
        

    }
}
