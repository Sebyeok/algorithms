import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer[]> queue = new ArrayDeque<>();
        for(int i = 0; i<priorities.length; i++)
            queue.offer(new Integer[]{i, priorities[i]});
        
        Deque<Integer> priorityQueue = new ArrayDeque<>();
        Arrays.sort(priorities);
        for(int priority:priorities) priorityQueue.offer(priority);
        
        while(queue.size()>0){
            Integer[] item = queue.poll();
            if(item[1] >= priorityQueue.peekLast()){
                answer++;
                if(item[0] == location) return answer;
                priorityQueue.pollLast();
            } else{
                queue.offer(item);
            }
        }
        
        
        return answer;
    }
}