package main.java.programmers.lv2;

// LV2 124 나라의 숫자
public class Solution66 {

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        solution66.solution(4);
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0){
            if(n % 3 == 0){
                sb.append(4);
                n = (n / 3) - 1;
            }
            else{
                sb.append(n % 3);
                n = n / 3;
            }
        }

        return sb.toString();
    }
}


