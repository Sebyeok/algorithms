import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        
        for(int num:nums) hs.add(num);
        
        int n = nums.length;
        int hsSize = hs.size();
        
        return hsSize > n/2 ? n/2:hsSize;
    }
}