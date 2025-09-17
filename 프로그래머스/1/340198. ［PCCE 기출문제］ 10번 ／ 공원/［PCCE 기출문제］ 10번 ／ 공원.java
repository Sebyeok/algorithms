import java.util.*;

class Solution {
    public List<int[]> calDotBySize(int x, int y, int size, int n, int m){
        List<int[]> dots = new ArrayList<int[]>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==0 && j==0) continue;
                dots.add(new int[]{x + i, y + j});
            }
        }
        return dots;
    }
    
    public int findMaxSize(int x, int y, String[][] park, int n, int m){
        int maxSize = 0;
        for(int k=1;k<=20;k++){
            if(calDotBySize(x, y, k, n, m)
                               .stream()
                               .allMatch(dot->dot[0]<n && dot[1]<m && park[dot[0]][dot[1]].equals("-1"))){
                maxSize = k;
            }
            else break;

        }
        return maxSize;   
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int n = park.length;
        int m = park[0].length;
        int maxSize = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(park[i][j].equals("-1")){
                    maxSize = Math.max(maxSize, findMaxSize(i, j, park, n, m));
                }
            }
        }
        
        for(int mat:mats){
            if(maxSize >= mat && maxSize>0){
                answer = Math.max(mat, answer);
            }
        }
        
        return answer;
    }
}