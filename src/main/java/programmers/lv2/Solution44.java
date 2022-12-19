package main.java.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// LV2 택배상자
public class Solution44 {

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        solution44.solution(new int[]{4, 3, 1, 2, 5});
    }

    public int solution(int[] order) {
        int cnt = 0;

        Stack<Integer> tmp = new Stack<>(); // 임시
        Queue<Integer> Q = new LinkedList<>(); // 기존

        for(int i=0; i<order.length; i++){
            tmp.add(i+1);

            while(!tmp.isEmpty()){
                if(tmp.peek() == order[cnt]){
                    Q.offer(tmp.pop());
                    cnt++;
                }else break;
            }
        }
        return Q.size();
    }

}


