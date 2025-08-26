import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    br.close();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(Integer.toString(pibo(n))+"\n");

    bw.flush();
    bw.close();
  }
  
  public static int pibo(int n) {
    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else
      return pibo(n - 1) + pibo(n - 2);
  }
}