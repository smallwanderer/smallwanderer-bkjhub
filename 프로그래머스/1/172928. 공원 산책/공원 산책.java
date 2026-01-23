import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int W = park[0].length();
        int H = park.length;
        Map<String, Integer[]> dtMap = Map.of(
            "N", new Integer[] {-1, 0},
            "E", new Integer[] {0, 1},
            "S", new Integer[] {1, 0},
            "W", new Integer[] {0, -1}
        );
        int[] S = StartFind(park, H, W);
        for (String r: routes) {
            String[] op = r.split(" ");
            int m = Integer.parseInt(op[1]);
            
            int dy = S[0];
            int dx = S[1];
            boolean flag = true;
            
            for(int k=0; k<m; k++) {
                dy += dtMap.get(op[0])[0];
                dx += dtMap.get(op[0])[1];
                
                if (dy >= H || dy < 0 || dx >= W || dx < 0) {
                    flag = false;
                    break;
                }
                if (park[dy].charAt(dx) == 'X') {
                    flag = false;
                    break;
                }
            }
            
            if (flag){
                S[0] = dy;
                S[1] = dx;
            }
            System.out.println(Arrays.toString(S));
        }

        return S;
    }
    
    private int[] StartFind(String[] park, int H, int W) {
        int[] S = new int[2];
        for (int i=0; i<H; i++) {
            for (int j=0; j<H; j++) {
                if (park[i].charAt(j) == 'S') {
                    S[0] = i;
                    S[1] = j;
                    return S;
                }
            }
        }
        return null;
    }
}