class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int days = timelogs[0].length;
        
        for (int man=0; man<schedules.length; man++) {
            int limit = addTen(schedules[man]);
            boolean ok = true;
            
            for (int d=0; d<days; d++) {             
                if (!weekend(startday+d) && timelogs[man][d] > limit) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) answer++;
        }
        
        return answer;
    }
    private int addTen(int time){
        time += 10;
        if (time % 100 >= 60) time += 40;
        return time;
    }
    
    private boolean weekend(int day) {
        return (day - 1) % 7 >= 5;
    }
}