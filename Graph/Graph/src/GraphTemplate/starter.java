package GraphTemplate;

public class starter {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{1,3}};
        int [][] edgeswithweight = {{0,1,10},{0,2,20},{1,3,30}};

        GraphUsingAdjMatrix graph = new GraphUsingAdjMatrix(4);
        graph.addEdgesInMatrix(edges,false);
        graph.printGraph();

        GraphTemplate.GraphUsingAdjList graph2 = new GraphUsingAdjList(4);
        graph2.addEdgesInList(edges,false);
        graph2.printGraph();


        GraphUsingAdjMatrix graph3 = new GraphUsingAdjMatrix(4);
        graph3.addEdgesInMatrixWithWeight(edgeswithweight,false);
        graph3.printGraph();

        GraphUsingAdjList graph4 = new GraphUsingAdjList(4);
        graph4.addEdgesInListWithWeight(edgeswithweight,false);
        graph4.printGraphwithWeight();
    }
}
