package GraphHardProblems;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        Collections.addAll(equations, new ArrayList<>(Arrays.asList("a", "b")), new ArrayList<>(List.of("b", "c")));
        double [] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        Collections.addAll(queries,new ArrayList<>(List.of("a","c")),new ArrayList<>(List.of("b","a")),new ArrayList<>(List.of("a","e")),new ArrayList<>(List.of("a","a")),new ArrayList<>(List.of("x","x")));

        double [] results = calcEquation(equations,values,queries);
        for(double val : results) System.out.print(val+" ");
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double result = values[i];
            if(!map.containsKey(dividend)){
                map.put(dividend, new HashMap<>());
            }
            if(!map.containsKey(divisor)){
                map.put(divisor, new HashMap<>());
            }
            map.get(dividend).put(divisor,result);
            map.get(divisor).put(dividend,1/result);
        }

        double results [] = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!map.containsKey(divisor) || !map.containsKey(dividend)){
                results[i] = -1;
            } else if (dividend.equals(divisor)) {
                results[i] = 1.0;
            } else{
                HashSet<String> visited = new HashSet<>();
                results[i] = dfs(dividend,divisor,1,visited,map);
            }
        }
        return results;
    }

    public static double dfs(String src,String target,double prod,HashSet<String> visited,Map<String,Map<String,Double>> map){
        double ret = -1.0;
        visited.add(src);
        if(map.get(src).containsKey(target)){
            ret = map.get(src).get(target) * prod;
        } else{
            for(String neighbour : map.get(src).keySet()){
                if(!visited.contains(neighbour)){
                    ret = dfs(neighbour,target,prod*map.get(src).get(neighbour),visited,map);
                    if(ret!=-1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return ret;
    }
}