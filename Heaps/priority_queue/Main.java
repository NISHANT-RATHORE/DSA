import java.util.*;
class Pt {
   int x = 0, y = 0, dis = 0;
 
 
   Pt(int x, int y) {
       this.x = x;
       this.y = y;
   }
}
 
 
class PtComparator implements Comparator<Pt> {
   public int compare(Pt pt1, Pt pt2) {
       if (pt1.dis < pt2.dis)
           return 1;
       return -1;
   }
}
 
 
public class Main {
   public static ArrayList<Pt> kClosestPoints(ArrayList<Pt> pts, int n, int k) {
       PriorityQueue<Pt> pq = new PriorityQueue<>(new PtComparator());
       for (int i = 0; i < n; i++) {
           pts.get(i).dis = pts.get(i).x + pts.get(i).y;
           pq.add(pts.get(i));
           if (pq.size() > k) {
               pq.poll();
           }
       }
       return new ArrayList<>(pq);
   }
 
 
 
 
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt(), k = sc.nextInt();
       ArrayList<Pt> pts = new ArrayList<>();
       for (int i = 0; i < n; i++) {
           pts.add(new Pt(sc.nextInt(), sc.nextInt()));
       }
       pts = kClosestPoints(pts, n, k);
       for (int i = 0; i < k; i++) {
           System.out.println(pts.get(i).x + " " + pts.get(i).y);
       }
   }
}