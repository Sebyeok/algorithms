import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐를 통해 scovile을 모두 넣고
        // 제일 위에 두 개를 빼고, 섞은 음식을 만든 후 다시 집어넣을 때, push.
        // 다시 pop을 해봤을 경우, k 이상이면 끝
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int score:scoville) pq.offer(score);
        
        while(pq.peek() < K){
            if(pq.size() <= 1) break;
            
            int item1 = pq.poll();
            int item2 = pq.poll();
            int newItem = item1 + item2 * 2;
            pq.offer(newItem);
            answer+=1;
        }
        
        if(pq.peek() < K) return -1;
        
        return answer;
    }
}