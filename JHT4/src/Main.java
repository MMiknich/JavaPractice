import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void fromTheEnd(Iterator<Integer> input)
    {
        if(input.hasNext()) {
            Integer output = input.next();
            fromTheEnd(input);
            System.out.println(output);
        }
    }
    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        List spisok = new ArrayList(Arrays.asList(arr));
        fromTheEnd(spisok.iterator());
        //System.out.print(spisok.iterator().next().getClass().toString());
    }
}
