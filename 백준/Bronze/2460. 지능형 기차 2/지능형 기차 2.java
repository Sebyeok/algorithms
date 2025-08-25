import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Integer person = 0;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            person -= Integer.parseInt(st.nextToken());
            person += Integer.parseInt(st.nextToken());
            max = Math.max(max,person);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(max)+"\n");
        bw.flush();
        bw.close();        
    }
}