import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {



    public static <run> void main(String[] args) {
        ArrayList<Student> studentList= new ArrayList<>(Arrays.asList(
                new Student("Ivan","UBbkcd", 18, "FPFE"),
                new Student("Igor","Knjhcb", 19, "FRTK"),
                new Student("Igor","Knjhcb", 19, "FRTK"),
                new Student("Alex","Lbjcs", 25, "FOPF"),
                new Student("Dilk","Hnldscn", 21, "FOPF"),
                new Student("Houih","Abhcs", 22, "DCAM"),
                new Student("Houih","Abhcs", 22, "DCAM"),
                new Student("Houih","Abhcs", 22, "FIFT"),
                new Student("Houih","Abhcs", 22, "FIFT"),
                new Student("Houih","Abhcs", 22, "DCAM")
        ));
        studentList.stream()
                .sorted(Comparator.comparing(Student::getFirstname))
                .forEach(student -> System.out.println(student.getFirstname() + " : " + student.getDepartment()));

        int topNumber = 3;
        System.out.print("Топ "+ topNumber +": ");
        studentList
                .stream()
                .sorted((student1, student2)  -> student1.departmentCompairing(student2, studentList))
                .distinct()
                .limit(topNumber)
                .collect(Collectors.toList())
                .stream()
                .forEach(st-> System.out.print(st.getDepartment() + " "));
    }
}
