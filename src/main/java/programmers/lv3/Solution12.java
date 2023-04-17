package main.java.programmers.lv3;

import java.util.TreeSet;

/**
 * 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
 */
public class Solution12 {

    public static void main(String[] args) {
        Solution12 Solution12 = new Solution12();
        Solution12.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
    }

    public int[] solution(String[] arguments) {
        TreeSet<Integer> PQ = new TreeSet<>();

        for (String argument : arguments) {
            String[] arg = argument.split(" ");
            int num = Integer.parseInt(arg[1]);
            if ("I".equals(arg[0])) {
                PQ.add(num);
                continue;
            }

            if (PQ.isEmpty())
                continue;

            if (num == 1) PQ.pollLast();
            else if (num == -1) PQ.pollFirst();
        }

        int[] answer = new int[2];
        if (PQ.size() > 1) {
            answer[0] = PQ.pollLast();
            answer[1] = PQ.pollFirst();
        } else if (PQ.size() == 1) {
            answer[0] = answer[1] = PQ.pollFirst();
        }

        return answer;
    }

}



