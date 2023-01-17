package main.java.programmers.lv2;

import java.util.Stack;

// LV2 괄호 회전하기
public class Solution65 {

    public static void main(String[] args) {
        Solution65 solution64 = new Solution65();
        solution64.solution("[](){}");
    }

    public int solution(String s) {
        int answer = 0;

        for(int i=0; i<s.length(); i++) {
            if(isCheck(s))
                answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }
    public boolean isCheck(String s) {
        Stack<Character> stack = new Stack();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty())
                stack.push(ch);
            else if(stack.peek() == '(' && ch == ')')
                stack.pop();
            else if(stack.peek() == '{' && ch == '}')
                stack.pop();
            else if(stack.peek() == '[' && ch == ']')
                stack.pop();
            else stack.push(ch);
        }
        return stack.isEmpty() ? true : false;
    }
}


