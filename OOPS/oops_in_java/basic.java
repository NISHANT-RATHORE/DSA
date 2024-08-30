package oops_in_java;

public class basic {
    static void display(Student sc){
        System.out.println(sc.name);
        System.out.println(sc.rollno);
        System.out.println(sc.percentage);
        System.out.println(sc.Schoolname);
        System.out.println();
    }
    public static void main(String[] args) {
        Student sc = new Student("Nishant Rathore", 1036, 95);  
        Student sc2 = new Student();
        sc2.name = "Tishant";
        sc2.rollno = 1025;
        sc2.percentage = 85;
        // display(sc);
        // display(sc2);
        System.out.println(Student.numberofstudents);
        System.out.println(Student.numberofstudents); 
    }
}
