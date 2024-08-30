public class hw {
    int [][] adjMatrix;
    hw(int nodes){
        adjMatrix = new int[nodes][nodes];
    }

    public void addedges(int [][] edges,boolean isDirected){
        for(int []subarr : edges){
            int u = subarr[0];
            int v = subarr[1];
            if (isDirected){
                adjMatrix[u][v] = 1;
            }
            else {
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }
    public void degree(int [][] edges,int nodes){
        int [] degree = new int[nodes];
        for(int [] subarr : edges){
            int u = subarr[0];
            int v = subarr[1];
            degree[u]++;
            degree[v]++;
        }
        for(int i=0;i<nodes;i++){
            System.out.println(i+" -> "+degree[i]);
        }
    }

    public void degree2(int [][] edges,int nodes){
        int [] indegree = new int[nodes];
        int [] outdegree = new int[nodes];
        for(int [] subarr : edges){
            int from = subarr[0];
            int to = subarr[1];
            indegree[to]++;
            outdegree[from]++;
        }
        for(int i=0;i<nodes;i++){
            System.out.println(i+" indegree -> "+indegree[i] +" "+ i+" outdegree -> "+outdegree[i]);
        }
    }

    public static void main(String[] args) {
        int [][] edges = {{0,2},{0,1},{1,3}};
        int nodes = 4;
        hw h = new hw(nodes);
        h.addedges(edges,false);
        h.degree(edges,nodes);

        h.addedges(edges,true);
        h.degree2(edges,nodes);
    }
}
