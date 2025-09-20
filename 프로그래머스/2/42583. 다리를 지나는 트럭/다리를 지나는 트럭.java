import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        // while 문으로 종료 조건 설정.
        // 매 초마다 새 트럭이 올라올 수 있는지 트럭 올릴 때 예상 하차 시간 체크, 무게 +, 트럭이 내려갈 수 있는지 -> 무게
        Deque<Integer[]> on_bridge = new ArrayDeque<>();
        int count = 0;
        int truckIdx = 0;
        int on_bridge_weights = 0;
        while(count < truck_weights.length){
            time++;
            if(on_bridge.size() > 0 && on_bridge.peek()[0] == time){
                on_bridge_weights -= on_bridge.poll()[1];
                count++;
            }
            if(truckIdx < truck_weights.length && truck_weights[truckIdx] + on_bridge_weights <= weight){
                on_bridge.offer(new Integer[]{bridge_length + time, truck_weights[truckIdx]});
                on_bridge_weights += truck_weights[truckIdx++];
            }
        }
        
        
        return time;
    }
}