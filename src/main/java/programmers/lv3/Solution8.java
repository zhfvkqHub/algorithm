package main.java.programmers.lv3;

/**
 * 기지국 설치
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979?language=java
 */
public class Solution8 {

    public static void main(String[] args) {
        Solution8 Solution8 = new Solution8();
        Solution8.solution(11, new int[]{4,11}, 1);
    }

    public static int solution(int n, int[] stations, int w) {
        int count = 0;
        int state = 0;
        int left = 1;
        int newleft;

        while(true) {
            if(state<stations.length && left >= stations[state] - w) {
                left = stations[state] + w + 1;
                state++;
            }else {
                newleft = left + w;

                if( (state <= stations.length - 2) && (newleft >= stations[state + 1] - w))
                    newleft = stations[state+1] - w - 1;

                left = newleft + w + 1;
                count++;
            }

            if(left > n) break;
        }
        return count;
    }

}



