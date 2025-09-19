import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        if(phone_book.length == 1) return false;

        HashSet<String> hs = new HashSet();
        
        Arrays.sort(phone_book);

        for(String phone:phone_book){
            if(!hs.contains(phone)){
                if(hs.size() > 0){
                    for(int i = 1; i <= phone.length(); i++){
                        if(hs.contains(phone.substring(0, i)))
                            return false;
                    }
                }
                hs.add(phone);
            } else return false;
        }
        return true;
    }
}