package main.java.v2.programmers.etc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * [Jabda]
 */
class J20260318_3Java {

    public int solution(String[] logs) {
        Map<String, Integer> loggedInUsers = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.split(" ");
            String userId = parts[0];
            String action = parts[1];
            int currentTime = Integer.parseInt(parts[2]);

            // 1. 현재 로그 처리 전에 자동 로그아웃 처리
            Iterator<Entry<String, Integer>> iterator = loggedInUsers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                int loginTime = entry.getValue();

                if (currentTime - loginTime >= 5) {
                    iterator.remove();
                }
            }

            // 2. 현재 로그 처리
            if ("LOGIN".equals(action)) {
                // 이미 로그인 상태면 무시
                if (!loggedInUsers.containsKey(userId)) {
                    loggedInUsers.put(userId, currentTime);
                }
            } else if ("LOGOUT".equals(action)) {
                // 로그인 상태일 때만 로그아웃
                loggedInUsers.remove(userId);
            }
        }

        return loggedInUsers.size();
    }

    public static void main(String[] args) {
        // 사용자의 로그인/로그아웃 기록이 주어진다
        // ["kim LOGIN 10", "lee LOGIN 12", "kim LOGOUT 15"]
        // 현재 로그인 상태인 사용자 수를 반환하라
        // 이미 로그인 상태에서 LOGIN → 무시
        // 로그인 안 된 상태에서 LOGOUT → 무시
        // time은 분 단위 정수

        // 세션 타임아웃 규칙
        //	•	사용자가 로그인한 뒤 5분이 지나도록 로그아웃하지 않으면 자동 로그아웃
        //	•	자동 로그아웃은 다음 로그를 처리하기 직전 적용된다고 가정한다

        J20260318_3Java solution = new J20260318_3Java();
        String[] logs1 = {"kim LOGIN 10", "lee LOGIN 12", "kim LOGOUT 14"};
        System.out.println(solution.solution(logs1)); // 1
        String[] logs2 = {"kim LOGIN 10", "lee LOGIN 12", "kim LOGOUT 16"};
        System.out.println(solution.solution(logs2)); // 1
        String[] logs3 = {"kim LOGIN 10", "kim LOGIN 12", "lee LOGOUT 13"};
        System.out.println(solution.solution(logs3)); // 1
    }
}
