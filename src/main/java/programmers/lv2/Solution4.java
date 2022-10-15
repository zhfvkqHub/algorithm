package main.java.programmers.lv2;

import java.util.*;

// 스택/큐 > 프린터
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){ // 우선순위 1위
                answer++;
                l--;

                if(l < 0) break;
            }else{
                que.add(i);
                l--;

                if(l < 0) l=que.size()-1;
            }
        }

        return answer;
    }
}
