package main.java.programmers.lv2;

// LV2 탐욕법(Greedy) > 큰 수 만들기
public class Solution38 {

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        solution38.solution("1924", 2);
    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i+1 < sb.length() && k>0; i++) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i=-1;
                k--;
            }
        }
        if(k!=0)
            sb.delete(sb.length()-k, sb.length());
        return sb.toString();
    }

}


