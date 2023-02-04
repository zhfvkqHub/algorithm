package main.java.programmers.lv2;

// LV2 마법의 엘리베이터
public class Solution73 {

    public static void main(String[] args) {
        Solution73 Solution73 = new Solution73();
        Solution73.solution(16);
    }

    public int solution(int storey) {

        if (storey == 0) return 0;
        if (storey % 10 == 0) return solution(storey/10);
        if (storey < 10) return Math.min(storey, 11-storey);

        int mod = storey % 10;
        int wayUp = 10 - mod + solution(storey + 10 - mod);
        int wayDown = mod + solution(storey - mod);

        return Math.min(wayUp, wayDown);
    }

}


