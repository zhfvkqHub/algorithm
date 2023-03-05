package main.java.programmers.lv3;

import java.util.Arrays;

// 숫자 게임
public class Solution3 {

    public static void main(String[] args) {
        Solution3 Solution3 = new Solution3();
        Solution3.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
    }
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index =0;
        for(int i=0; i<A.length; i++) {
            for(int j=index; j<B.length; j++) {
                if(A[i] < B[j]) {
                    index = j + 1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}



