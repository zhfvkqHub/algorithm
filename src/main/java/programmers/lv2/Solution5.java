package main.java.programmers.lv2;

import java.util.*;

// 스택/큐 > 기능개발
public class Solution5 {

    class Info{
        int gauge, speed;
        public Info(int gauge, int speed) {
            this.gauge = gauge;
            this.speed = speed;
        }
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        solution5.solution(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        Queue<Info> qu = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            qu.offer(new Info(progresses[i],speeds[i]));
        }

        while(!qu.isEmpty()){
            int pop = 0;
            Info q = qu.poll();

            if(q.gauge >= 100) { //추출가능
                boolean continuity = true;
                pop++;
                int lastQu = qu.size();
                for(int i=0; i<lastQu; i++){
                    Info childQ = qu.poll();
                    if(continuity){
                        if(childQ.gauge >= 100){
                            pop++;
                        }else{
                            qu.add(new Info(childQ.gauge+ childQ.speed, childQ.speed ));
                            continuity = false;
                        }
                    }else{
                        qu.add(new Info(childQ.gauge+ childQ.speed, childQ.speed ));
                    }
                }
                ans.add(pop);
            }else{ // 추출불가
                qu.add(new Info(q.gauge+q.speed, q.speed));
                for(int i=0; i<qu.size()-1; i++){
                    Info childQ = qu.poll();
                    qu.add(new Info(childQ.gauge+ childQ.speed, childQ.speed));
                }
            }
        }

        int[] answer = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }

        for(int a : answer){
            System.out.print(a + " ");
        }

        return answer;
    }
}
