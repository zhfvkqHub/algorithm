package main.java.programmers.lv2;

// LV2 다음 큰 숫자
public class Solution29 {

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        solution29.solution(78);
    }

    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int nextCnt;

        while(true) {
            n ++;
            nextCnt = Integer.bitCount(n);
            if(cnt == nextCnt) break;
        }

        return n;
    }
}

