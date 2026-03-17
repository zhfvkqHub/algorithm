package main.java.v2.programmers.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [Jabda]
 */
class J20260317_2Java {

    public String[] solution(String[] records) {
        List<String> answer = new ArrayList<>();
        String prev = "";
        int count = 0;

        for (String record : records) {
            if (record.equals(prev)) {
                count++;
            } else {
                if (!prev.isEmpty()) {
                    answer.add(prev + (count > 1 ? ":" + count : ""));
                }
                prev = record;
                count = 1;
            }
        }

        // 마지막 메시지 처리
        if (!prev.isEmpty()) {
            answer.add(prev + (count > 1 ? ":" + count : ""));
        }

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        // 채팅 서버는 같은 메시지가 연속으로 여러 번 전송되면 이를 압축해서 저장합니다.
        // ex. ["hi", "hi", "hi", "ok", "ok", "bye", "bye", "bye", "bye"] -> ["hi:3", "ok:2", "bye:4"]
        // 단, 1번만 나온 메시지는 ":1"을 붙이지 않고 원본 그대로 저장해야 합니다.
        // ex. ["hello", "world", "world"] -> ["hello", "world:2"]

        J20260317_2Java solution = new J20260317_2Java();
        String[] records = {"hi", "hi", "hi", "ok", "ok", "bye", "bye", "bye", "bye"};
        System.out.println(Arrays.toString(solution.solution(records))); // ["hi:3", "ok:2", "bye:4"]
        String[] records2 = {"hello", "world", "world"};
        System.out.println(Arrays.toString(solution.solution(records2))); // ["hello", "world:2"]
    }
}
