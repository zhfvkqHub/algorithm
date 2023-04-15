package main.java.programmers.lv3;

import java.util.HashSet;
import java.util.Set;

/**
 * 불량 사용자
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */
public class Solution10 {

    public static void main(String[] args) {
        Solution10 Solution8 = new Solution10();
        Solution8.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
    }

    public Set<Set<String>> set = new HashSet<>();
    public boolean[] visited = new boolean[8];

    public int solution(String[] user_id, String[] banned_id) {
        findBannedId(banned_id, user_id, 0, new HashSet<>());
        return set.size();
    }

    public void findBannedId(String[] banned_id, String[] user_id, int index, Set<String> names) {
        if(index == banned_id.length) {
            set.add(new HashSet(names));
            return;
        }

        for(int i = 0; i < user_id.length; i++) {
            if(visited[i])
                continue;

            if(isSame(banned_id[index], user_id[i])) {
                visited[i] = true;
                names.add(user_id[i]);
                findBannedId(banned_id, user_id, index + 1, names);
                names.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }

    public boolean isSame(String target, String goal) {
        if(target.length() != goal.length())
            return false;

        for(int i = 0; i < target.length(); i++) {
            if(target.charAt(i) == '*')
                continue;

            if(target.charAt(i) != goal.charAt(i))
                return false;
        }
        return true;
    }

}



