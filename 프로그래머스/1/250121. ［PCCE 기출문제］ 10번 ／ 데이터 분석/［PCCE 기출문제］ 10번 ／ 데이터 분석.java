import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> dataMap = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
        
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int[] d: data) {
            if (d[dataMap.get(ext)] < val_ext) arrayList.add(d);
        }
        
        ArrayList<int[]> sortedList = mergeSort(arrayList, dataMap.get(sort_by));
        
        return sortedList.toArray(new int[sortedList.size()][4]);
    }
    
    private ArrayList<int[]> mergeSort(ArrayList<int[]> data, int sort_idx) {
        if (data.size() == 1) return data;
        int mid = data.size() / 2;
        
        ArrayList<int[]> left = mergeSort(new ArrayList<>(data.subList(0, mid)), sort_idx);
        ArrayList<int[]> right = mergeSort(new ArrayList<>(data.subList(mid, data.size())), sort_idx);
        
        return merge(left, right, sort_idx);
    }
    
    private ArrayList<int[]> merge(ArrayList<int[]> left, ArrayList<int[]> right, int sort_idx) {
        ArrayList<int[]> mergedArr = new ArrayList<>();
        int lidx = 0;
        int ridx = 0;
        
        while (lidx < left.size() && ridx < right.size()) {
            if (left.get(lidx)[sort_idx] <= right.get(ridx)[sort_idx]) {
                mergedArr.add(left.get(lidx));
                lidx++;
            } else {
                mergedArr.add(right.get(ridx));
                ridx++;
            }
        }
        
        while (lidx < left.size()) mergedArr.add(left.get(lidx++));
        while (ridx < right.size()) mergedArr.add(right.get(ridx++));
        
        return mergedArr;
    }
}