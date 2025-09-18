import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> q = new LinkedList<>();
        for (int num : arr) {
            if (q.isEmpty() || !q.peekLast().equals(num)) {
                q.offerLast(num);
            }
        }
        int[] answer = new int[q.size()];
        int i = 0;
        while (!q.isEmpty()) answer[i++] = q.pollFirst();
        return answer;
    }
}