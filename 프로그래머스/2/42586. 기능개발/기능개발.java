import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] calculateDay = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        
        int top = -1;
        for(int i = 0; i < n; i++){
            calculateDay[i] = (int) Math.ceil((100 - progresses[i])/(double) speeds[i]);
            if(i == 0){
                top = calculateDay[i];
                deque.offerLast(1);
            } else {
                if(top >= calculateDay[i]){
                    deque.offerLast(deque.pollLast() + 1);
                } else{
                    top = calculateDay[i];
                    deque.offerLast(1);
                }
            }
        }
        int size = deque.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = deque.pollFirst();
        }
        
        return answer;
    }
}