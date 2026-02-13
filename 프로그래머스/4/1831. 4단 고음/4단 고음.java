// stack[] 구조로 DFS를 구현하면 시간초과가 발생함. (왜인지는 모르겠음;;;)

class Solution {
    public int solution(int n) {
        int answer = 0;
        long curSum = 1;
        int stage = 0;
        while (curSum < n) {
            curSum = curSum * 3 + 2;
            ++stage;
        }

        System.out.print(stage);

        answer += DFS(stage*2 - 1, stage, n-1, 1);
        return answer;
    }

    public int DFS(int one, int three, int target, int validSum) {
        if (target == 3 && one == 0 && three == 1) return 1;
        else if(validSum < 0) return 0;
        else if (target > 3) {
            int sum = 0;
            if (one > 0) {
                sum += DFS(one-1, three, target-1, validSum+1);    
            }
            if (three > 0 && one / 2 <= three && target % 3 == 0) {
                sum += DFS(one, three-1, target/3, validSum-2);  
            }
            return sum;
        } else {
            return 0;
        }     
    }
}