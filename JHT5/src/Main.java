import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void fromTheEndAdition(ArrayList<Double> inpArray)
    {
        fromTheEndAdition(inpArray.iterator(), inpArray);
        return;
    }

    public static void fromTheEndAdition(Iterator<Double> inputIter, ArrayList<Double> inpArray)
    {
        if(inputIter.hasNext()) {
            Double output = inputIter.next();
            fromTheEndAdition(inputIter, inpArray);
            if (output >= 0)
            {
                inpArray.add(output);
            }
        }
        return;
    }
    public static void main(String[] args) {
        ArrayList <Double> spisok = new ArrayList<>();
        spisok.add(00.10);
        spisok.add(05.10);
        spisok.add(17.10);
        spisok.add(-09.10);
        spisok.add(-00.10);
        fromTheEndAdition(spisok);

        for (int i = 0; i < spisok.size(); i++) {
            System.out.println(spisok.get(i));
        }
        return;
    }
}
