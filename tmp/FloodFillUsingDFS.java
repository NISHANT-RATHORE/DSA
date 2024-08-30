import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloodFillUsingDFS {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int [][] res = floodFill(image,sr,sc,color);
        for(int [] arr : res){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        boolean [][] isVisited = new boolean[rows][cols];
        dfs(sr,sc,color,image[sr][sc],isVisited,image);
        return image;
    }
    private static void dfs(int row,int col,int newColor,int currColor,boolean isVisited[][],int image[][]){
        if(row<0 || row >= rows || col<0 || col >=cols || image[row][col]!=currColor || isVisited[row][col]){
            return;
        }
        image[row][col] = newColor;
        isVisited[row][col] = true;

        int [][] adjMatrix = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int [] neighbour : adjMatrix){
            dfs(neighbour[0],neighbour[1],newColor,currColor,isVisited,image);
        }
    }

    public static class GraphUsingList {
        class Pair{
            int node;
            int weight;

            @Override
            public String toString() {
                return "("
                         + node +
                        "," + weight +
                        ")";
            }

            public Pair(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }
        static List<List<Integer>> adjList;
        static List<List<Pair>> adjListwithWeight;

        GraphUsingList(int nodes){
            adjList = new ArrayList<>();
            adjListwithWeight = new ArrayList<>();
            for (int i=0;i<nodes;i++){
                adjList.add(new ArrayList<>());
            }

            for (int i=0;i<nodes;i++){
                adjListwithWeight.add(new ArrayList<>());
            }
        }

    //    public void findDegreeUndirectedGraph(int [][] edges , int nodes) {
    //        int[] degree = new int[nodes];
    //        for(int [] edge : edges){
    //            int u = edge[0];
    //            int v = edge[1];
    //            degree[u]++;
    //            degree[v]++;
    //        }
    //        for(int i=0;i<nodes;i++){
    //            System.out.println(i+"->"+degree[i]);
    //        }
    //    }

    //    public void findDegreeDirectedGraph(int [][] edges , int nodes) {
    //        int[] Indegree = new int[nodes];
    //        int[] Outdegree = new int[nodes];
    //        for(int [] edge : edges){
    //            int from = edge[0];
    //            int to = edge[1];
    //            Indegree[to]++;
    //            Outdegree[from]++;
    //        }
    //        System.out.println("indegree");
    //        for(int i=0;i<nodes;i++){
    //            System.out.println(i+"->"+Indegree[i]);
    //        }
    //        System.out.println("outdegree");
    //        for(int i=0;i<nodes;i++){
    //            System.out.println(i+"->"+Outdegree[i]);
    //        }
    //
    //    }


        public void addEdgesInMatrix(int [][] edges,boolean isDirected){
            for(int [] edge : edges){
                int u = edge[0];
                int v = edge[1];
                if(isDirected){
                    adjList.get(u).add(v);
                } else{
                    adjList.get(u).add(v);
                    adjList.get(v).add(u);
                }
            }
        }
        public void addEdgesInMatrixwithWeight(int [][] edges,boolean isDirected){
            for(int [] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(isDirected){
                    Pair pair = new Pair(v,w);
                    adjListwithWeight.get(u).add(pair);
                } else{
                    Pair pair1 = new Pair(v,w);
                    Pair pair2 = new Pair(u,w);
                    adjListwithWeight.get(u).add(pair1);
                    adjListwithWeight.get(v).add(pair2);
                }
            }
        }
        public static void printList(){
            int i = 0;
            for (List<Integer> integers : adjList){
                System.out.print(i++ +" -> ");
                System.out.println(integers);
            }
            System.out.println();
        }
        public static void printListwithWeight(){
            int i = 0;
            for (List<Pair> pair : adjListwithWeight){
                System.out.print(i++ +" -> ");
                System.out.println(pair);
            }
            System.out.println();
        }


        public static void main(String[] args) {
            int [][] edges = {{0,1},{0,2},{1,3}};
            int [][] edgeswithweight = {{0,1,10},{0,2,20},{1,3,30}};
            int nodes = 4;
            //        -------------------------------------UNWEIGHTED GRAPH----------------------------------------------------------
            //undirected graph
            System.out.println("--------UNWEIGHTED GRAPH-------------");
            System.out.println("Undirected Graph");
            GraphUsingList g = new GraphUsingList(4);
            g.addEdgesInMatrix(edges,false);
            printList();
    //        g.findDegreeUndirectedGraph(edges,nodes);
            System.out.println();

            System.out.println("Directed Graph");
            GraphUsingList g2 = new GraphUsingList(4);
            g2.addEdgesInMatrix(edges,true);
            printList();
    //        g.findDegreeDirectedGraph(edges,nodes);
            System.out.println();

            //        -------------------------------------WEIGHTED GRAPH----------------------------------------------------------
            //undirected graph
            System.out.println("--------WEIGHTED GRAPH-------------");
            System.out.println("Undirected Graph");
            GraphUsingList g3 = new GraphUsingList(4);
            g3.addEdgesInMatrixwithWeight(edgeswithweight,false);
            printListwithWeight();

            System.out.println("Directed Graph");
            GraphUsingList g4 = new GraphUsingList(4);
            g4.addEdgesInMatrixwithWeight(edgeswithweight,true);
            printListwithWeight();
        }
    }
}
