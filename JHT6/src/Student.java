
import java.util.ArrayList;

public class Student {
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
    private String department = "";

    public Student(String firstName, String lastName, int age, String department)
    {
        this.age = age;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstname(){
        return this.firstName;
    }
    public String getLastname(){
        return this.lastName;
    }
    public int getAge(){
        return this.age;
    }
    public String getDepartment(){
        return this.department;
    }
    public int departmentCompairing(Student st2, ArrayList<Student> arrayList) {
        long Dp1 =  arrayList.stream().filter(student -> student.getDepartment().equals(this.getDepartment())).count();
        long Dp2 = arrayList.stream().filter(student -> student.getDepartment().equals(st2.getDepartment())).count();
        if (Dp1 == Dp2)
            return 0;
        else if(Dp1 > Dp2)
            return -1;
        else
            return 1;
    }
    public boolean equals (Object a) {
        if(a.getClass() == this.getClass()){
            return this.getDepartment().equals(((Student)a).getDepartment());
        }
        else return false;
    }
        /* Я имею нулевой опыт написания программ на жаве(да и в ооп я не так давно),
     и то что вы видите возможно (определенно точно)  вызвет крупное кровоизлияние из ваших глаз,
      но все это делается только со знанием того, что .distinct использует .hashCode() и .equals() и все это надо было коекак переписать,
      **я не знаю почему работает ((Student)a).getDepartment()), но вроде работает, с одной стороны оно не должно вызывать проблем, т.к.
      a априори будет Student, но мой внутренний Сишник говорит: "Шо це такое!? Это хоть и явное, но не описанное преобразование"**

      P.S. Если увидите этот комментарий, напишите мне, пожалуйста, можно ли так делать, и вообще, это костыль или элегантное решение проблемы?

            */
    public int hashCode()
    {
        return this.getDepartment().hashCode();
    }
}
