import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // -곱해서 + 하는거랑 그냥 +하는거랑 queue에 하나씩 넣고 bfs로 합 구하고, target 수랑 같은지 확인
        Deque<Integer[]> queue = new ArrayDeque<>();
        
        queue.offerLast(new Integer[]{numbers[0], 0});
        queue.offerLast(new Integer[]{-numbers[0], 0});

        while(!queue.isEmpty()){
            Integer[] item = queue.pollFirst();
            int sum = item[0];
            int nextIdx = item[1] + 1;
            if(nextIdx < numbers.length){
                queue.offerLast(new Integer[]{sum + numbers[nextIdx], nextIdx});
                queue.offerLast(new Integer[]{sum - numbers[nextIdx], nextIdx});
            }else if(sum == target) answer++;
        }
        
        return answer;
    }
}