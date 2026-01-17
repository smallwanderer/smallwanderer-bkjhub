class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int F = friends.length;
        
        int[][] gift_cnt = new int[F][F];
        int[] gift_factor = new int[F];
        for (String gift: gifts) {
            String[] ab = gift.split(" ");
            int a = friend_idx(friends, F, ab[0]);
            int b = friend_idx(friends, F, ab[1]);
            
            gift_cnt[a][b]++;
            gift_factor[a]++;
            gift_factor[b]--;
        }
        
        for (int i=0; i<F; i++) {
            int cnt = 0;
            for (int j=0; j<F; j++) {
                if (i==j) continue;
                if (gift_cnt[i][j] > gift_cnt[j][i]) {
                    cnt++;
                } else if (gift_cnt[i][j] == gift_cnt[j][i]) {
                    if (gift_factor[i] > gift_factor[j]) cnt++;
                }
            }
            answer = (answer >= cnt) ? answer : cnt;
        }
        
        return answer;
    }
    
    private int friend_idx(String[] friends, int F, String friend) {
        int idx = 0;
        for (; idx<F; idx++) {
            if (friend.equals(friends[idx])) break;
        }
        return idx;
    }
    
}