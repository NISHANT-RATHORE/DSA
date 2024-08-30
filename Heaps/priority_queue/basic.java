package priority_queue;
import java.util.*;

public class basic {
    public static class Student{
        String name;
        int rollno;
        int marks;
    }
    public static class StudentComparator implements Comparator<Student>{
        public int compare(Student s1,Student s2){
            if(s1.marks > s2.marks) return -1;
            else if(s1.marks < s2.marks) return 1;
            else return 0;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(10,20,30,40,50,60,5));
        PriorityQueue<Student> pq2 = new PriorityQueue<>(new StudentComparator());
        Student bm = new Student();
        Student nr = new Student();
        bm.name = "BM";
        bm.rollno = 3;
        bm.marks = 200;

        nr.name = "NR";
        nr.marks = 300;
        nr.rollno = 66;
        pq2.add(bm); // add the Student object to pq2
        pq2.add(nr);
        // System.out.println(pq);
        // pq.remove();
        // System.out.println(pq);
        System.out.println(pq2.peek().name); // print pq2
        System.out.println(pq2.peek().marks);
        System.out.println(pq2.peek().rollno);
    }
}