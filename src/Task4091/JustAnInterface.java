package Task4091;

public interface JustAnInterface {
    public static final B B = new B();

    class B extends C {
        public B() {
            System.out.print("B");
        }
    }
}