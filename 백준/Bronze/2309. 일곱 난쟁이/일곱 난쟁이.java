import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> heights = new ArrayList<Integer>();
    
    for (int i = 0; i < 9; i++) {
      heights.add(Integer.parseInt(br.readLine()));
    }
    br.close();

    boolean find = false;
    int i = 0;
    int j = 0;
    for (i = 0; i < 8; i++) {
      for (j = i + 1; j < 9; j++) {
        int sum = 0;
        for (int k = 0; k < 9; k++) {
          if (k != i && k != j)
            sum += heights.get(k);
        }
        if (sum == 100) {
          find = true;
          break;
        }
      }
      if (find == true) {
        break;
      }
    }

    List<Integer> answers = new ArrayList<Integer>();

    for (int k = 0; k < 9; k++) {
      if (k != i && k != j) {
        answers.add(heights.get(k));
      }
    }
    answers.sort(Comparator.naturalOrder());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int num : answers) {
      bw.write(Integer.toString(num)+"\n");
    }
    bw.flush();
    bw.close();

  }
}