package main.java.programmers.lv2;

// LV2 점 찍기
public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        solution47.solution(2,4);
    }

    public long solution(int k, int d) {
        long answer = 0;

        long dd = (long) Math.pow(d,2);
        for(int x = 0; x <= d; x = x+k){

            long xx = (long) Math.pow(x,2);
            int max_y = (int)Math.pow(dd-xx,0.5);
            answer += (max_y)/k + 1;

        }

        return answer;
    }

}


