class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int MAX_HEALTH = health;
        int time = 0;
        int heal = 0;
        int attack = 0;
        
        while (true) {
            System.out.println(time + ": " + health);
            time++;
            if (time == attacks[attack][0]) {
                health -= attacks[attack][1];
                heal = 0;
                if (health <= 0){
                    health = -1;
                    break;
                }
                
                attack++;
                if (attack == attacks.length) break;
                
                continue;
            }
            
            int[] after_heal = healing(health, heal, MAX_HEALTH, bandage);
            heal = after_heal[0];
            health = after_heal[1];
        }
        return health;
    }
    
    private int[] healing(int health, int heal, int mh, int[] bandage) {
        int[] after_heal = {heal, health};
        
        after_heal[0]++;
        after_heal[1] += bandage[1];
        
        if (after_heal[0] == bandage[0]) {
            after_heal[1] += bandage[2];
            after_heal[0] = 0;
        }
        
        if (health >= mh) after_heal[1] = mh;
        return after_heal;
    }
}