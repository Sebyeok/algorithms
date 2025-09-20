import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // Stack이 비면 스택에 [현재 값, 인덱스를] 넣는다.
        // 현재 값을 만났을 때, 스택 최상단 친구보다 현재 값이 작아지면 pop
        // 현재 인덱스 - 스택 인덱스를 하면 초가 나온다.
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{prices[0], 0});
        for(int i=1; i<prices.length; i++){
            Integer[] item = stack.peek();
            while(!stack.empty() && item[0] > prices[i]){
                answer[item[1]] = i - item[1];
                stack.pop();
                if(!stack.empty()) item = stack.peek();
                else break;
            }
            if(i < prices.length -1) stack.push(new Integer[]{prices[i], i});
        }
        
        while(!stack.empty()){
            Integer[] item = stack.pop();
            answer[item[1]] = prices.length - 1 - item[1];
        }
        
        return answer;
    }
}