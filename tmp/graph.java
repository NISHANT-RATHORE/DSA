import java.util.Arrays;

public class graph {
    int adjMatrix[][];
    graph(int nodes){
        adjMatrix = new int[nodes][nodes];
    }
    public void addEdgesInMatrix(int [][] edges,boolean isDirected){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(isDirected){
                adjMatrix[u][v] = 1;
            } else{
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    public void addEdgesInMatrixWithWeight(int [][] edges,boolean isDirected){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(isDirected){
                adjMatrix[u][v] = w;
            } else{
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }

    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{1,3}};
        int [][] edgeswithweight = {{0,1,10},{0,2,20},{1,3,30}};
        int nodes = 4;
        graph g = new graph(nodes);
//        -------------------------------------UNWEIGHTED GRAPH----------------------------------------------------------
        //undirected graph
        System.out.println("--------UNWEIGHTED GRAPH-------------");
        System.out.println("Undirected Graph");
        g.addEdgesInMatrix(edges,false);
        for(int [] arr : g.adjMatrix){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
        System.out.println();

        //directed graph
        System.out.println("Directed Graph");
        graph g2 = new graph(nodes);
        g2.addEdgesInMatrix(edges,true);
        for(int [] arr : g2.adjMatrix){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
        System.out.println();

//        -------------------------------------WEIGHTED GRAPH----------------------------------------------------------
        //undirected graph
        System.out.println("--------WEIGHTED GRAPH-------------");
        System.out.println("Undirected Graph");
        graph g3 = new graph(nodes);
        g3.addEdgesInMatrixWithWeight(edgeswithweight,false);
        for(int [] arr : g3.adjMatrix){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
        System.out.println();

        //directed graph
        System.out.println("Directed Graph");
        graph g4 = new graph(nodes);
        g4.addEdgesInMatrixWithWeight(edgeswithweight,true);
        for(int [] arr : g4.adjMatrix){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
        System.out.println();

    }
}
