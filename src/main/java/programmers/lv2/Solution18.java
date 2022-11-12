package main.java.programmers.lv2;

// LV2 멀쩡한 사각형
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        solution18.solution(8, 12);

    }

    public long solution(int w,int h) {
        int gcdnum = gcd(w, h);
        long result = (long)w * (long)h - ((long)w + (long)h - gcdnum);
        return result;
    }

    public int gcd(int w, int h){
        if (h == 0) {
            return w;
        } else {
            return gcd(h, w % h);
        }
    }
}
