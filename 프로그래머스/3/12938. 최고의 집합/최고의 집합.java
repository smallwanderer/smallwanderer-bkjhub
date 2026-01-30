class Solution {
    public int[] solution(int n, int s) {
        if (s<n) {
            return new int[] {-1};
        }
        
        int share = s / n;
        int remainer = s % n;
        int[] result = new int[n];
        for (int idx=0; idx<n; idx++) {
            result[idx] = share;
        }
        for (int i=0; i<remainer; i++) {
            result[n-i-1]++;
        }
        return result;
    }
}