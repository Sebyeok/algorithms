import java.util.*;

class Solution {
    public boolean[] visited;
    public void dfs(int start, int n, int[][] computers){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(start);
        visited[start] = true;
        while(!stack.isEmpty()){
            int node = stack.pollFirst();
            for(int i=0; i<n; i++){
                if(!visited[i] && computers[node][i] == 1){
                    stack.offerFirst(i);
                    visited[node] = true;
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                answer++;
                dfs(i, n, computers);
            }  
        }
        
        return answer;
    }
}