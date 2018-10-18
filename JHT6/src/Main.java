import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {

    public static int departmentCompairing(Student st1, Student st2, ArrayList<Student> arrayList) {
        long Dp1 =  arrayList.stream().filter(student -> student.getDepartment().equals(st1.getDepartment())).count();
        long Dp2 = arrayList.stream().filter(student -> student.getDepartment().equals(st2.getDepartment())).count();
        if (Dp1 == Dp2)
            return 0;
        else if(Dp1 > Dp2)
            return -1;
        else
            return 1;
    }

    public static <run> void main(String[] args) {
        ArrayList<Student> studentList= new ArrayList<>();
        Student aa = new Student("Ivan","UBbkcd", 18, "FPFE");
        Student bb = new Student("Igor","Knjhcb", 19, "FRTK");
        Student bb1 = new Student("Igor","Knjhcb", 19, "FRTK");
        Student cc = new Student("Alex","Lbjcs", 25, "FOPF");
        Student dd = new Student("Dilk","Hnldscn", 21, "FOPF");
        Student ee = new Student("Houih","Abhcs", 22, "DCAM");
        Student ee1 = new Student("Houih","Abhcs", 22, "DCAM");
        Student ee2 = new Student("Houih","Abhcs", 22, "FIFT");
        Student ee3 = new Student("Houih","Abhcs", 22, "FIFT");
        Student ee4 = new Student("Houih","Abhcs", 22, "FIFT");
        Student ee5 = new Student("Houih","Abhcs", 22, "DCAM");
        studentList.add(aa);
        studentList.add(bb);
        studentList.add(bb1);

        studentList.add(cc);
        studentList.add(dd);
        studentList.add(ee);
        studentList.add(ee1);
        studentList.add(ee2);
        studentList.add(ee3);
        studentList.add(ee4);
        studentList.add(ee5);
        studentList.stream()
                .sorted(
                        (a,b) -> a.getFirstname().compareTo(b.getFirstname()))
                    .forEach(
                            student -> System.out.println(student.getFirstname() + " : " + student.getDepartment()));

        System.out.print("Топ 3: ");
        List<Student> output = studentList
                        .stream()
                        .sorted((student1, student2)  -> departmentCompairing(student1, student2, studentList))
                        .distinct()
                        .limit(3)
                        .collect(Collectors.toList());
        output.stream().forEach(st-> System.out.print(st.getDepartment() + " "));
    }
}
