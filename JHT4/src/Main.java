import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void FromTheEnd(Iterator<String> input)
    {
        if(input.hasNext()) {
            String output = input.next();
            FromTheEnd(input);
            System.out.println(output);
        }
    }
    public static void main(String[] args) {
        ArrayList <String> spisok = new ArrayList<>();
            spisok.add("1");
            spisok.add("2");
            spisok.add("3");
            spisok.add("4");
            spisok.add("5");
            spisok.add("6");
            spisok.add("7");
            spisok.add("8");
            spisok.add("9");
            spisok.add("10");
            spisok.add("11");
            spisok.add("12");
            spisok.add("13");
            spisok.add("14");
            spisok.add("15");
            spisok.add("16");
            spisok.add("17");
            spisok.add("18");
            spisok.add("19");
            spisok.add("20");

        Iterator<String> forRecusion = spisok.iterator();
        FromTheEnd(forRecusion);
    }
}
