import java.util.*;

class Solution {
//     List<List<String>> combList = new ArrayList<>();
//     List<String> keys = new ArrayList<>();
    
//     public void comb (int start, int r, List<String> list){
//         if(list.size() == r){
//             combList.add(new ArrayList<>(list));
//         } else {
//             for (int i = start; i < keys.size(); i++) {
//                 list.add(keys.get(i));
//                 comb(i + 1, r, list);
//                 list.remove(list.size()-1);
//             }
//         }
//     }
    
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hm = new HashMap();
        for(String[] clotheArr: clothes)
            hm.put(clotheArr[1], hm.getOrDefault(clotheArr[1], 0) + 1);
        
        for(String key:hm.keySet())
            answer *= hm.get(key) + 1;

//         for(String key:hm.keySet()) keys.add(key);
        
//         for(int i=1; i<=keys.size();i++){
//             comb(0, i, new ArrayList<>());
//         }

//         for(List<String> list:combList){
//             int temp = 1;
//             for(String key:list){
//                 temp *= hm.get(key);
//             }
//             answer += temp;
//         }
        
        return answer-1;
    }
}