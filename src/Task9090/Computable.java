package Task9090;

/* Argument and Value are generic types*/
public interface Computable<Argument, Value> {
    Value compute(Argument argument) throws InterruptedException;
}
