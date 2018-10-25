import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {
        int MAXOUTLEN = 5;
        int MINOUTLEN = 3;
        String fileName = "tmp.csv";
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

        try(FileWriter writer = new FileWriter(fileName,false)) {
            String outStr[] = new String[MAXOUTLEN + 1];
            for (Integer i = MINOUTLEN; i <= MAXOUTLEN; i++)
                outStr[i] =  i.toString();

            input.stream()
                    .filter(s-> s.length() <= MAXOUTLEN && s.length() >= MINOUTLEN)
                    .forEach(s-> outStr[s.length()] += (" | " + s));

            Arrays.stream(outStr)
                    .forEach(s-> {
                        try {if (s != null)
                                writer.write(s + "\n");}
                        catch (IOException e) {e.printStackTrace();}
                    });

        }
        catch (IOException ex){System.out.println(ex.getMessage());};
    }
}
