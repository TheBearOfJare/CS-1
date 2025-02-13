public class X {
    private int a;
    private int b;

    public X() {
        this(1, 2);
    }

    // public X() {
    //     a = 1;
    //     b = 2;
    // }


    public X(int a, int b) {
        this.a = a;
        this.b = b;
    }

    

    public long sum() {
        return this.a + this.b;

    }

    public long doSomething(X annex) {
        return this.a * annex.b;
    }
}
