import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map <String, Integer> memory = new HashMap<String, Integer>();
        for (int i=0; i<name.length; i++) {
            memory.put(name[i], yearning[i]);
        }
        Set<String> keySet = memory.keySet();
        for (String key: keySet) {
            System.out.println(key + ":" + memory.get(key));
        }
        
        int photo_length = photo.length;
        int[] answer = new int[photo_length];
        for (int i=0; i<photo_length; i++) {
            int r = 0;
            for (String person: photo[i]) {
                if (!memory.containsKey(person)) continue;
                r += memory.get(person);
            }
            answer[i] = r;
        }
        return answer;
    }
}