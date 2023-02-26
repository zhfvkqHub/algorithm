package main.java.programmers.lv2;

import java.util.Stack;

// 뒤에 있는 큰 수 찾기
public class Solution78 {

    public static void main(String[] args) {
        Solution78 Solution78 = new Solution78();
        Solution78.solution(new int[]{2, 3, 3, 5});
    }

    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; ++i) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                result[index] = numbers[i];
            }

            stack.add(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1;
        }

        return result;
    }
}


