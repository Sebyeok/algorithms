import java.io.*;
import java.util.*;

public class Main {
  static int[] arr;
  static List<Integer> answer;

  static boolean found = false;

  static void comb(int n, int r, int start, List<Integer> temp) {
    if (found == true)
      return;

    if (temp.size() == r) {
      if (temp.stream().reduce(0, (a, c) -> a + c) == 100) {
        answer = new ArrayList(temp);
        found = true;
      }
      return;
    }
    for (int i = start; i <= n-(r-temp.size()); i++) {
      temp.add(arr[i]);
      comb(n, r, i + 1, temp);
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    arr = new int[9];
    
    for (int i = 0; i < 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();


    comb(9, 7, 0, new ArrayList<>());

    Collections.sort(answer);
    for(int i:answer)
      System.out.println(i);
  }
}
