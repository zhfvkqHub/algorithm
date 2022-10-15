package main.java.programmers.lv2;

// 스택/큐 > 올바른 괄호
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.solution("()()");
    }
    boolean solution(String s) {
        boolean answer = false;

        int count = 0;
        for(int i = 0; i<s.length(); i++){

            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;
            if(count < 0) break;

        }
        if(count == 0)
            answer = true;

        return answer;
    }
}
