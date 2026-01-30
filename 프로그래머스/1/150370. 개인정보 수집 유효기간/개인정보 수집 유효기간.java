import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> tmap = new HashMap<>();
        for (String t: terms) {
            String[] tmp = t.split(" ");
            tmap.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        // System.out.println(tmap.toString());
        
        String[] today_tmp = today.split("\\.");
        int todays = Integer.parseInt(String.join("", today_tmp));
        System.out.println(todays);
        
        for (int i=0; i<privacies.length; i++) {
            String[] privacies_tmp = privacies[i].split(" ");
            // System.out.println(Arrays.toString(privacies_tmp));
            String[] date_str = privacies_tmp[0].split("\\.");
            // System.out.println(Arrays.toString(date_str));
            
            int year = Integer.parseInt(date_str[0]);
            int month = Integer.parseInt(date_str[1]);
            month += tmap.get(privacies_tmp[1]);
            if (month > 12) {
                year += (month-1) / 12;
                month = (month-1) % 12 + 1;
            }
            int day = Integer.parseInt(date_str[2]) - 1;
            if (day == 0) {
                month--;
                day = 28;
                if (month == 0) {
                    year--;
                    month = 12;
                }
            }
            int date = year * 10000 + month * 100 + day;

            if (todays > date) answer.add(i+1);
        }
        int[] result = new int[answer.size()];
        Iterator<Integer> iter = answer.iterator();
        int idx = 0;
        while(iter.hasNext()){
            result[idx] = iter.next();
            idx++;
        }

        return result;
    }
}