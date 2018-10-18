import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void FromTheEndAdition(Iterator<Double> input, ArrayList<Double> inparray)
    {
        if(input.hasNext()) {
            Double output = input.next();
            FromTheEndAdition(input, inparray);
            if (output >= 0)
            {
                inparray.add(output);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList <Double> spisok = new ArrayList<>();
        spisok.add(00.10);
        spisok.add(05.10);
        spisok.add(17.10);
        spisok.add(-09.10);
        spisok.add(-00.10);

        Iterator<Double> forRecusion = spisok.iterator();
        FromTheEndAdition(forRecusion, spisok);

        for (int i = 0; i < spisok.size(); i++) {
            System.out.println(spisok.get(i));
        }

    }
}
