class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        int[][] dp = new int[n][n];

        for (int i=0; i<n; i++) {
            dp[i][i] = cookie[i];
        }

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
               dp[i][j] = dp[i][j-1] + cookie[j]; 
            }
        }
        
        for (int i=0; i<n-1; i++) {
            int leftPointer = i;
            int rightPointer = i+1;
            while (leftPointer >= 0 && rightPointer < n) {
                int leftSum = dp[leftPointer][i];
                int rightSum = dp[i+1][rightPointer];
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                    leftPointer--;
                    rightPointer++;
                    continue;
                }
                if (leftSum < rightSum) {
                    leftPointer--;
                    continue;
                }
                rightPointer++;
            }
        }
        return answer;
    }
}