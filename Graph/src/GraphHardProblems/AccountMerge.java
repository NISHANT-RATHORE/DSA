package GraphHardProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        Collections.addAll(accounts,
                new ArrayList<>(List.of("John","johnsmith@mail.com","john_newyork@mail.com")),
                new ArrayList<>(List.of("John","johnsmith@mail.com","john00@mail.com")),
                new ArrayList<>(List.of("Mary","mary@mail.com")),
                new ArrayList<>(List.of("John","johnnybravo@mail.com"))
        );
        System.out.println(accountsMerge(accounts));
    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<String>> adjMap = new HashMap<>();

        for (List<String> account : accounts){
            String firstEmail = account.get(1);
            for(int i=2;i<account.size();i++){
                String email = account.get(i);
                if(!adjMap.containsKey(firstEmail)){
                    adjMap.put(firstEmail,new ArrayList<>());
                }
                adjMap.get(firstEmail).add(email);

                if(!adjMap.containsKey(email)){
                    adjMap.put(email,new ArrayList<>());
                }
                adjMap.get(email).add(firstEmail);
            }
        }

        List<List<String>> res = new ArrayList<>();
        Set<String> isVisited = new HashSet<>();
        for (List<String> account : accounts){
            String firstMail = account.get(1);
            if(!isVisited.contains(firstMail)){
                List<String> subList = new ArrayList<>();
                dfs(firstMail,isVisited,adjMap,subList);
                Collections.sort(subList);
                subList.add(0,account.get(0));
                res.add(subList);
            }
        }

        return res;
    }

    public static void dfs(String firstMail,Set<String> isVisited,Map<String,List<String>> adjMap,List<String> subList){
        isVisited.add(firstMail);
        subList.add(firstMail);
        if (!adjMap.containsKey(firstMail)){
            return;
        }
        for (String neighbour : adjMap.get(firstMail)){
            if(!isVisited.contains(neighbour)){
                dfs(neighbour,isVisited,adjMap,subList);
            }
        }
    }
}
