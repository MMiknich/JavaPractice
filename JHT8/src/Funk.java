@FunctionalInterface
public interface Funk<A, B, R>  {
    R apply(A a, B b);
}
