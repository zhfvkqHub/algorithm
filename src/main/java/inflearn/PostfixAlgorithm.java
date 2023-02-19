package main.java.inflearn;

import java.util.Scanner;
import java.util.Stack;

public class PostfixAlgorithm {

    public static void main(String[] args) {
        PostfixAlgorithm T = new PostfixAlgorithm();
        
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
        
    }

    private int solution(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) // 숫자
                stack.push(x - 48);
            else { // 연산자
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') stack.push(lt + rt);
                else if (x == '-') stack.push(lt - rt);
                else if (x == '*') stack.push(lt * rt);
                else if (x == '/') stack.push(lt / rt);
            }

        }
        return stack.get(0);
    }


}
