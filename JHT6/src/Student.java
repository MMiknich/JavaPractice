import org.jetbrains.annotations.Contract;

public class Student {
    private String Firstname = "";
    private String Lastname = "";
    private int Age = 0;
    private String Department = "";

    public Student(String fN, String lN, int age, String dep)
    {
        this.Age = age;
        this.Department = dep;
        this.Firstname = fN;
        this.Lastname = lN;
    }
    public String getFirstname(){
        return this.Firstname;
    }
    public String getLastname(){
        return this.Lastname;
    }
    public int getAge(){
        return this.Age;
    }
    public String getDepartment(){
        return this.Department;
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
