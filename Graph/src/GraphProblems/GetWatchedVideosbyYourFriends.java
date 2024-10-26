package GraphProblems;
import java.util.*;

public class GetWatchedVideosbyYourFriends {

    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>();
        Collections.addAll(watchedVideos,new ArrayList<>(List.of("A","B")),new ArrayList<>(List.of("C")),new ArrayList<>(List.of("B","C")),new ArrayList<>(List.of("D")));
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        int id = 0,level = 1;
        List<String> res = watchedVideosByFriends(watchedVideos,friends,id,level);
        for(String val : res) System.out.print(val+ " ");
    }
    static class Pair implements Comparable<Pair>{
        String video;
        int freq;

        public Pair(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair that) {
            if(this.freq == that.freq){
                return this.video.compareTo(that.video);
            }
            return this.freq - that.freq;
        }
    }
    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int curLevel = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int node = queue.poll();
                for(int neighbour : friends[node]){
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            curLevel++;
            if(curLevel == level) break;
        }
        Map<String,Integer> map = new HashMap<>();
        while (!queue.isEmpty()){
            int currId = queue.poll();
            for(String video : watchedVideos.get(currId)){
                map.put(video,map.getOrDefault(video,0)+1);
            }
        }
        List<Pair> pair = new ArrayList<>();
        for(String video : map.keySet()){
            pair.add(new Pair(video,map.get(video)));
        }
        Collections.sort(pair);

        for(Pair p : pair){
            res.add(p.video);
        }
        return res;
    }
}