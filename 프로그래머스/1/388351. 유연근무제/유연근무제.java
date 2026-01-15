class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int total_mans = schedules.length;
        int total_days = timelogs[0].length;
        
        for (int man=0; man<total_mans; man++) {
            int cnt = 0;
            int schedule = schedules[man] + 10;
            if (schedule % 100 >= 60) {
                schedule = schedule + 40;
            }
            System.out.println(schedule);
            
            for (int day=0; day<total_days; day++) {             
                if ((timelogs[man][day] <= schedule) || weekend(day+startday)){
                    cnt++;
                }
            }
            if (cnt == total_days) answer++;
        }
        
        return answer;
    }
    
    private boolean weekend(int day) {
        return (day - 1) % 7 >= 5;
    }
}