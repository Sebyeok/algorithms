import java.util.*;

class Solution {
     private int toSec(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    private String toMMSS(int sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }
    private int skipOpeningIfNeeded(int pos, int ops, int ope) {
        if (pos >= ops && pos <= ope) return ope;
        return pos;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int V = toSec(video_len);
        int P = toSec(pos);
        int OPS = toSec(op_start);
        int OPE = toSec(op_end);

        P = skipOpeningIfNeeded(P, OPS, OPE);

        for (String cmd : commands) {
            P = skipOpeningIfNeeded(P, OPS, OPE);

            if ("prev".equals(cmd)) {
                P = Math.max(0, P - 10);
            } else { // "next"
                P = Math.min(V, P + 10);
            }

            P = skipOpeningIfNeeded(P, OPS, OPE);
        }
        return toMMSS(P);
    }
}