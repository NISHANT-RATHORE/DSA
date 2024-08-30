package oops_in_java;

public class Student {
    String name;
    int rollno;
    double percentage;
    final String Schoolname = "APS";
    static int numberofstudents;
    public int getrolno(){ //getter 
        return rollno;
    }
    public void setrolno(int roll){ //setter
        rollno = roll;
    }
    public Student(String name,int roll,double percent){ //Constructor
        this.name = name;
        rollno = roll;
        percentage = percent;
        numberofstudents++;
    }
    public Student(){

    }
    
}
