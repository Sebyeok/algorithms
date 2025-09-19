import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String item:participant)
            map.put(item, map.getOrDefault(item, 0) + 1);
        
        for(String item:completion){
            Integer count = map.get(item);
            if(count == 1)
                map.remove(item);
            else
                map.put(item, count - 1);
        }
        
        for(String key:map.keySet()) answer = key;
        
        return answer;
    }
}