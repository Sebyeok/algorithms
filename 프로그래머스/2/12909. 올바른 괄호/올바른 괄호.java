import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            char item = s.charAt(i);
            if(item == '('){
                stack.push('(');
            } else{
                if(stack.size()==0){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.size()==0)
            return true;
        
        return false;
    }
}