package main.java.programmers.lv2;

// LV2 점프와 순간 이동
public class Solution42 {

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        solution42.solution(5);
    }

    public int solution(int n) {
        int sub = 1;
        int ans = 0;
        while(n != 0){
            if(n % 2 == 1){
                n -= sub;
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }

}


