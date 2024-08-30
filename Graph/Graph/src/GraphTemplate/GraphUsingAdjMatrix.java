package GraphTemplate;

import java.util.Arrays;

public class GraphUsingAdjMatrix {
    int adjMatrix[][];
    public GraphUsingAdjMatrix(int nodes){
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

    public void printGraph(){
        for(int [] subarr : adjMatrix){
            Arrays.stream(subarr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
        System.out.println();
    }
}
