import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> no = new HashSet<>();
        for(char c: skip.toCharArray()) no.add(c);
        
        // Iterator iter = no.iterator();
        // while(iter.hasNext()) System.out.println(iter.next());
        
        StringBuilder out = new StringBuilder(s.length());
        for (char ch: s.toCharArray()) {
            char cur = ch;
            int moved = 0;
            
            while (moved < index) {
                cur = (char) ('a' + (cur - 'a' + 1) % 26);
                if (no.contains(cur)) continue;
                moved++;
            }
            
            out.append(cur);
        }
        return out.toString();
    }
}