class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        wallet = sort_two(wallet);
        bill = sort_two(bill);
        while (true) {
            boolean ok = true;
            for (int i=0; i<2; i++) {
                if (bill[i] > wallet[i]) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) break;
            
            bill[1] = bill[1] / 2;
            answer++;
            bill = sort_two(bill);
        }
        
        return answer;
    }
    
    private int[] sort_two(int[] a){
        if (a[0] > a[1]) {
            int temp = a[0];
            a[0] = a[1];
            a[1] = temp;
        }
        return a;
    }
}