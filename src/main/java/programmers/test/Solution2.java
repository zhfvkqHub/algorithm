package main.java.programmers.test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(new int[]{1,2,3});

    }

    public int[] solution(int[] queue) {
        int[] answer = new int[3];
        int[] cntQu = new int[3];

        Queue<Integer> Qu = new LinkedList<>();

        for(int q : queue){
            cntQu[q-1] += 1;
            Qu.offer(q);
        }

        int max =0;
        for(int i=0; i<cntQu.length; i++){
            max = Math.max(cntQu[i],max);
        }

        int addNum = 0;
        while (true){
            int minNum = max;

            for(int i=0; i<cntQu.length; i++) {
                if (minNum > cntQu[i]) {
                    minNum = cntQu[i];
                    addNum = i;
                    answer[i] ++;
                }
            }

            if(minNum == max) break;

            int pollNum = Qu.poll();
            Qu.offer(minNum);

            cntQu[pollNum-1] -= 1;
            cntQu[addNum] += 1;
        }

        return answer;
    }


}
