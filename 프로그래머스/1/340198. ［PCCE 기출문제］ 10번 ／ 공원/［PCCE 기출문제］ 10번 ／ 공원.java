import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int h = park.length;
        int w = park[0].length;
        int answer = -1;
        
        boolean[][] empty = new boolean[h][w];
        for (int y=0; y<h; y++) {
            for (int x=0; x<w; x++) {
                empty[y][x] = "-1".equals(park[y][x]);
            }
        }
        
        Arrays.sort(mats);
        
        for (int i=mats.length-1; i>=0; i--) {
            int size = mats[i];
            //if (size <= answer) break;
            
            if (squareSearch(empty, h, w, size)) {
                answer = size;
                break;
            }
        }        
        
        return answer;
    }
    
    private boolean squareSearch(boolean[][] empty, int h, int w, int size) {        
        for (int y=0; y+size<=h; y++) {
            for (int x=0; x+size<=w; x++) {
                if (!empty[y][x]) continue;
                
                boolean ok = true;
                for (int dy=0; dy < size && ok; dy++) {
                    for (int dx=0; dx < size && ok; dx++) {
                        if (!empty[y+dy][x+dx]) ok = false;
                    }
                }
                
                if (ok) return true;
            }
        }
        return false;
    }
}