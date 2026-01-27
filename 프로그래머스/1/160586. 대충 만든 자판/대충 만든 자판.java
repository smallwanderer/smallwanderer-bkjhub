import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int INF = 101;
        int[] KeyMap = new int[26];
        Arrays.fill(KeyMap, INF);
        
        for (String key: keymap) {
            for (int i=0; i<key.length(); i++) {
                int idx = key.charAt(i) - 'A';
                KeyMap[idx] = Math.min(KeyMap[idx], i+1);
            }
        }
        
        int n = targets.length;
        int[] answer = new int[n];
        
        for (int i=0; i<n; i++) {
            String target = targets[i];
            int sum = 0;
            
            for (int j=0; j<target.length(); j++) {
                int idx = target.charAt(j) - 'A';
                if (KeyMap[idx] == INF) {
                    sum = -1;
                    break;
                }
                sum += KeyMap[idx];
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}