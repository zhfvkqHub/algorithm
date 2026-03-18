package main.java.v2.programmers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [Jabda]
 */
class J20260317_1Java {

    public String[] solution(String[] records) {
        Set<String> set = new HashSet<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String name = split[0];
            String action = split[1];

            if ("IN".equals(action)) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        // Set을 List로 변환하여 사전순으로 정렬
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        // 하루가 끝난 뒤, 아직 회사 안에 남아 있는 직원 이름을 사전순으로 반환하세요.

        J20260317_1Java solution = new J20260317_1Java();
        String[] records = {"kim IN", "lee IN", "kim OUT", "park IN", "lee OUT"};
        System.out.println(Arrays.toString(solution.solution(records))); // [park]

        String[] records2 = {"a IN", "b IN", "c IN", "a OUT", "d IN"};
        System.out.println(Arrays.toString(solution.solution(records2))); // [b, c, d]
    }
}
