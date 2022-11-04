package main.java.programmers.lv2;

import java.util.Stack;

// LV2 짝지어 제거하기
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        solution11.solution("baabaa");

    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.size() == 0){
                stack.push(c);
            }
            else if(stack.peek() == c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        return stack.size() > 0 ? 0 : 1;
    }

}
