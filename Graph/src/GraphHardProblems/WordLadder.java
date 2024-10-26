package GraphHardProblems;
import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        if(!set.contains(endWord)){
            return 0;
        }
        queue.offer(beginWord);
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level = 0;
        while (!queue.isEmpty()){
            int curLevelSize = queue.size();
            for(int i=0;i<curLevelSize;i++){
                String node = queue.poll();
                if(node.equals(endWord)){
                    return level+1;
                }
                List<String> neighbours = getNeighbours(node,set);
                for(String neighbour : neighbours){
                    if(set.contains(neighbour)) {
                        queue.offer(neighbour);
                        set.remove(neighbour);
                    }
                }
            }
            level++;
        }

        return 0;
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
}
