import com.sun.org.apache.xpath.internal.functions.Function2Args;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static Function<Integer, Integer> intFunc = (a)->(new Integer(1));
    public static Funk<Predicate<Integer>, Predicate<Integer>, Predicate<Integer> funk
            = (predicate1 , predicate2) -> (intFunc.apply(1) > 0)
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
