import java.util.Arrays;

class Solution {
    public int solution(int n, int w, int num) {
        int q = n / w;
        int r = n % w;
        
        int nq = (num-1) / w;
        int nr = (num-1) % w;
        
        System.out.println(q + " " + r);
        System.out.println(nq + " " + nr);
        
        int[] parcel = new int[w];
        Arrays.fill(parcel, q);
        
        if (q%2 == 1){
            for (int i=w-r; i<w; i++) {
                parcel[i]++;
            }
        } else {
            for (int i=0; i<r; i++) {
                parcel[i]++;
            }
        }
        
        System.out.println(Arrays.toString(parcel));
        
        int index;
        if (nq%2 == 1) {
            index = w - nr - 1;
        } else {
            index = nr;
        }
        
        System.out.println(index+" "+nq);
        
        return parcel[index] - nq;
    }
}