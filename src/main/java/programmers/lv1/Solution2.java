package main.java.programmers.lv1;

import java.util.Stack;

public class Solution2 {

    public void testDy(){
        // 크레인 인형뽑기 게임
        int[][] board = new int[][]{{0,0,0,0,0},{0,0,3,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[]{2,2,3,3,2,1,4,5};

        solution(board, moves);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stk = new Stack();

        // 1. 배열에 moves번째의 board 값을 담는다
        for(int i = 0; i < moves.length; i++){
            int k = moves[i];
            for(int j = 0; j < board.length; j++){
                if(board[j][k-1] == 0){
                    continue;
                }
                if(stk.empty()){
                    stk.push(board[j][k-1]);
                    board[j][k-1] = 0;
                    break;
                }
                if(board[j][k-1] == stk.peek()){
                    stk.pop();
                    answer += 2;
                }else{
                    stk.push(board[j][k-1]);
                }
                board[j][k-1] = 0;
                break;
            }
        }

        System.out.println("answer ==> " + answer);
        return answer;
    }
}
