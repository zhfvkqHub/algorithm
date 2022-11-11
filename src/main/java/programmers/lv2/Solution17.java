package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

// LV2 혼자 놀기의 달인
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        solution17.solution(new int[]{8,6,3,7,2,5,1,4});

    }

    public int solution(int[] cards) {
        boolean[] visit = new boolean[cards.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < cards.length;i++){
            int idx = i;
            int tmp = 0;
            while(!visit[idx]){
                visit[idx] = true;
                idx = cards[idx] - 1;
                tmp++;
            }
            if(tmp > 0){
                list.add(tmp);
            }
        }
        Collections.sort(list);
        if(list.size() == 1){
            return 0;
        }
        return list.get(list.size() - 1) * list.get(list.size() - 2);
    }

}
