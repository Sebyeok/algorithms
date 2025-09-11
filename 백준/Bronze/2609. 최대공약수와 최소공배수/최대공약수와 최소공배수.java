import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    br.close();

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    if (b > a) {
      int temp = a;
      a = b;
      b = temp;
    }
    int rest = a % b;
    int gcd = b;

    while (rest != 0) {
      int temp = rest;
      rest = gcd % rest;
      gcd = temp;
    }
    
    int lcm = a * b / gcd;

    System.out.println(gcd);
    System.out.println(lcm);
  }
}