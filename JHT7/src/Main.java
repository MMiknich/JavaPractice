import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("1");
        input.add("22");
        input.add("333");
        input.add("333");
        input.add("dju");
        input.add("djut");
        input.add("dj34u");
        input.add("djeeeu");
        input.add("djokl;u");
        input.add("djdfu");
        input.add("djfu");
        input.add("dj");
        input.add("dju");
        input.add("dju");
        input.add("dju");
        input.add("dju");
        input.add("dju");

        try(FileWriter writer = new FileWriter(".csv",false)) {
            for (int j = 3; j <=5;j++) {
                final int k = j;
                if (input.stream().filter(s -> s.length() == k).count() > 0) {
                    String output = new String("");
                    output += new Integer(j).toString();
                    List<String> out =
                            input.stream()
                                    .filter(a -> a.length() == k)
                                    .collect(Collectors.toList());
                    for (int i = 0; i < out.size(); i++)
                        output += (" | " + out.get(i));
                    output += "\n";
                    writer.write(output);
                }
            }

        }
        catch (IOException ex){System.out.println(ex.getMessage());};
    }
}
