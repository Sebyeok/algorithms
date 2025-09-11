import java.util.*;
import java.io.*;

public class Main {
  static List<Integer> answers = new ArrayList<Integer>();
  public static void permutation(int target, int sum, int idx, List<Integer> result) {
    if (sum == target) {
      answers.set(idx, answers.get(idx) + 1);
    } else if(sum>target){
      return;
    } else {
      for (int i = 1; i <= 3;i++){
        result.add(i);
        permutation(target, sum + i, idx, result);
        result.remove(result.size() - 1);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> nums = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      nums.add(Integer.parseInt(br.readLine()));
    }

    br.close();

    for (int i = 0; i < n; i++) {
      answers.add(0);
      for (int j = 1; j <= 3; j++) {
        permutation(nums.get(i), j, i, new ArrayList<Integer>(List.of(j)));
      }
    }

    for (int answer : answers) {
       System.out.println(answer);
    }
   
  }
}