package main.java.programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 과제 진행하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962?language=java
 */
public class Solution82 {

    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        solution82.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
    }

    public String[] solution(String[][] plans) {

        // 과제 시간 순으로 우선 순위 큐 정렬
        PriorityQueue<Plan> pq = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.start)
        );

        for(String[] plan : plans) {
            int start = stringToint(plan[1]);
            pq.add(new Plan(plan[0], start, Integer.parseInt(plan[2])));
        }


        Stack<Plan> stack = new Stack<>(); // 못 끝낸 과제
        String[] answer = new String[plans.length];
        int idx = 0;
        int nowTime = 0;

        // 새 과제 OR 못끝낸 과제
        while(!pq.isEmpty() || !stack.isEmpty()) {
            if(pq.isEmpty()) {
                answer[idx++] = stack.pop().task;
            }
            else if (stack.isEmpty()) {
                nowTime = pq.peek().start;
                stack.add(pq.poll());
            }
            else {
                if(pq.peek().start < nowTime + stack.peek().time) {
                    stack.peek().time -= pq.peek().start - nowTime;
                    nowTime = pq.peek().start;
                    stack.push(pq.poll());
                }
                else {
                    nowTime += stack.peek().time;
                    answer[idx++] = stack.pop().task;
                }
            }

        }

        return answer;
    }

    public int stringToint(String start) {
        String[] str = start.split(":");
        int h = Integer.parseInt(str[0]) * 60;
        int m = Integer.parseInt(str[1]);
        return h+m;
    }

    public static class Plan {
        String task; //과제 이름
        int start; //과제 시작 시간(분)
        int time; //과제 걸리는 시간
        public Plan(String task, int start, int time) {
            this.task = task;
            this.start = start;
            this.time = time;
        }
    }
}



