import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreSumHm = new HashMap();
        HashMap<String, PriorityQueue<Integer[]>> hm = new HashMap();
        
        int n = genres.length;
        for(int i = 0; i < n; i++){
            if(hm.get(genres[i]) != null){
                genreSumHm.put(genres[i], genreSumHm.get(genres[i]) + plays[i]);
                hm.get(genres[i]).add(new Integer[]{i, plays[i]});
            } else{
                genreSumHm.put(genres[i], plays[i]);
                PriorityQueue<Integer[]> newPq = new PriorityQueue<>((a, b) -> {
                        if(Integer.compare(b[1], a[1]) == 0){
                            return Integer.compare(a[0], b[0]);
                        } else {
                            return Integer.compare(b[1], a[1]);
                        }
                        
                    });
                newPq.add(new Integer[]{i, plays[i]});
                hm.put(genres[i], newPq);
            }
        }

        List<String> genreKeyList = new ArrayList<>(genreSumHm.keySet());
        genreKeyList.sort((a,b)-> genreSumHm.get(b) - genreSumHm.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        
        for(String genre:genreKeyList){
            PriorityQueue<Integer[]> queue = hm.get(genre);
            for(int i=0; i<2; i++){
                if(!queue.isEmpty())
                    answerList.add(queue.poll()[0]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++) answer[i] = answerList.get(i); 
        
        return answer;
    }
}