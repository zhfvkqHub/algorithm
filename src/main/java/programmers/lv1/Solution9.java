package main.java.programmers.lv1;

import java.util.Arrays;

public class Solution9 {

    public void testDy(){
        // 탐욕법 > 체육복
        int n = 7;
        int[] lost = new int[]{1,2,3,4,5,6,7};
        int[] reserve = new int[]{1,2,3};
        solution(n,lost,reserve);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        n = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌의 옷이 있고, 잃어버린 학생
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    n ++;
                    break;
                }
            }
        }
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                 if(lost[i] - reserve[j]  == 1 || reserve[j] - lost[i] == 1){
                    reserve[j] = -1;
                    n ++;
                    break;
                 }
            }
        }
        System.out.println("n ===> " + n);
        return n;
    }
}
