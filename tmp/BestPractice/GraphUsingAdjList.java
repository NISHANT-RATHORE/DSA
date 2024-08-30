package BestPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair{
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + node +
                "," + weight +
                ')';
    }
}
public class GraphUsingAdjList {

//    int [][] adjMatrix;
    List<List<Integer>> adjList;

    List<List<Pair>> adjListwithWeight;
    GraphUsingAdjList(int nodes){
//        adjMatrix = new int[nodes][nodes];
        adjList = new ArrayList<>();
        adjListwithWeight = new ArrayList<>();
        for (int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
            adjListwithWeight.add(new ArrayList<>());
        }
    }

    public void addEdgesInList(int [][] edges,boolean isDirected){
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

    public void addEdgesInListWithWeight(int [][] edges,boolean isDirected){
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

    public void printGraph(){
        int i = 0;
        for(List<Integer> al : adjList){
            System.out.print(i++ +" -> ");
            System.out.println(al);
        }
        System.out.println();
    }

    public void printGraphwithWeight(){
        int i = 0;
        for(List<Pair> al : adjListwithWeight){
            System.out.print(i++ +" -> ");
            System.out.println(al);
        }
        System.out.println();
    }

}
