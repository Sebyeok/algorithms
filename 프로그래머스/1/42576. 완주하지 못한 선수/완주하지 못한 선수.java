import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String item:participant){
            if(map.get(item) != null){
                map.put(item, map.get(item) + 1);
            } else{
                map.put(item, 1);
            }
        }
        for(String item:completion){
            map.put(item, map.get(item) - 1);
        }
        for(String key:map.keySet()){
            if(map.get(key) == 1)
               answer = key;
        }
        
        return answer;
    }
}