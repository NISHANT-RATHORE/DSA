package GraphHardProblems;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        List<List<String>> res = findLadders(beginWord,endWord,wordList);
        System.out.println(res);
    }
    private static List<String> getNeighbours(String node, Set<String> set) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<node.length();i++){
            for(char c = 'a' ; c <= 'z' ; c++){
                if(c == node.charAt(i)) continue;
                String newWord = node.substring(0,i) + c + node.substring(i+1);
                if(set.contains(newWord)){
                    res.add(newWord);
                }
            }
        }
        return res;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();

        if(!set.contains(endWord)){
            return res;
        }

        List<String> dummy = new ArrayList<>();
        dummy.add(beginWord);

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(dummy);

        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level = 0;
        int resLevel = 0;
        while (!queue.isEmpty()){
            Set<String> usedWords = new HashSet<>();
            int curLevelSize = queue.size();
            for(int i=0;i<curLevelSize;i++){
                List<String> nodeList = queue.poll();
                String node = nodeList.get(nodeList.size()-1);
                if(node.equals(endWord)){
                    res.add(nodeList);
                    resLevel = level;
                }
                List<String> neighbours = getNeighbours(node,set);
                for(String neighbour : neighbours){
                    if(set.contains(neighbour)) {
                        nodeList.add(neighbour);
                        queue.offer(new ArrayList<>(nodeList));
                        nodeList.remove(neighbour);
                        usedWords.add(neighbour);
                    }
                }
            }
            for(String visited : usedWords){
                set.remove(visited);
            }
            level++;
            if(level == resLevel) break;
        }

        return res;
    }
}
