public class Driver {
    public static final void main(String[] args) {
        X ex = new X(8,7);

        X exx = new X(25,22);

        System.out.println("Ex sum = " + ex.sum());
        System.out.println("Exx sum = " + exx.sum());
        System.out.println("Do Something: " + ex.doSomething(exx));
    }
}    

