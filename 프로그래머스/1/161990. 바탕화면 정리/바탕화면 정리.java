import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int H = wallpaper.length;
        int W = wallpaper[0].length();
        int lux = H + 1;
        int luy = W + 1;
        int rdx = 0;
        int rdy = 0;
        
        for (int col=0; col<H; col++) {
            String[] rowArr = wallpaper[col].split("");
            // System.out.println(Arrays.toString(rowArr));
            for (int row=0; row<W; row++) {
                if (rowArr[row].equals(".")) continue;
                
                lux = Math.min(lux, col);
                luy = Math.min(luy, row);
                rdx = Math.max(rdx, col + 1);
                rdy = Math.max(rdy, row + 1);
            }
        }
        
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}