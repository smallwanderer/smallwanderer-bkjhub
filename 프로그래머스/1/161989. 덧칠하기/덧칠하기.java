class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] wall = new boolean[n];
        for (int idx: section) {
            wall[idx-1] = true;
        }

        int answer = 0;
        int i = 0;
        while (i < n) {
            if (!wall[i]) {
                i++;
                continue;
            }
            System.out.println(i);
            answer ++;
            i += m;
        }
        return answer;
    }
}