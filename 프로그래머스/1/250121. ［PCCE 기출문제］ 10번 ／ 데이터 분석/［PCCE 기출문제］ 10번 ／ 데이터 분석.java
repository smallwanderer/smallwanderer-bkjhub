import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> dataMap = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
        int val_idx = dataMap.get(ext), sort_idx = dataMap.get(sort_by);
        int[][] answer = Arrays.stream(data).filter(a -> a[val_idx] < val_ext)
            .sorted((a, b) -> Integer.compare(a[sort_idx], b[sort_idx]))
            .toArray(int[][]::new);
        return answer;
    }
}