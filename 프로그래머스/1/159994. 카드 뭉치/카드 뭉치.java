class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int A = cards1.length;
        int B = cards2.length;
        int aidx = 0;
        int bidx = 0;
        for (int i=0; i<goal.length; i++) {
            String word = goal[i];
            if (aidx < A && cards1[aidx].equals(word)) {
                aidx++;
            } else if (bidx < B && cards2[bidx].equals(word)) {
                bidx++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}