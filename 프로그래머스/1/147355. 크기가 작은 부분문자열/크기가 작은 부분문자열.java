import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int N = p.length();
        long compare = Long.parseLong(p);
        char[] list_t = t.toCharArray();
        for (int i=0; i<=list_t.length-N; i++) {
            String tmp = t.substring(i, i+N);
            if(Long.parseLong(tmp) <= compare) answer++;
        }
        return answer;
    }
}