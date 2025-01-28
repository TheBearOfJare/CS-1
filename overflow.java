public class overflow {


    public static final void main(String[] args) {
        long time = System.currentTimeMillis();
        int x = (short)1;

        while ((short)x != 0) {
            x += 1;
            System.out.println((short)x);
        }
        long end = System.currentTimeMillis();
        System.out.print("Back to 0 in: ");
        System.out.print((end-time));
        System.out.println("ms");
    }
    
}