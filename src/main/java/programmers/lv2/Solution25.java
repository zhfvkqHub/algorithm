package main.java.programmers.lv2;

// LV2 스킬트리
public class Solution25 {
    public static void main(String[] args) {
        Solution25 solution23 = new Solution25();
        solution23.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

    public int solution(String skill, String[] skill_trees) {

        int answer = -1;
        int length = skill_trees.length;
        answer = length;

        int before = 0;
        int now = 0;

        for( int i = 0; i < length; i++ ) {
            before = skill_trees[i].indexOf(skill.charAt(0));

            for(int j = 1; j < skill.length(); j++ ) {
                now = skill_trees[i].indexOf(skill.charAt(j));

                if(( before > now && now != -1) || (before == -1 && now != -1)){
                    answer--;
                    break;
                }

                before = now;
            }
        }

        return answer;

    }
}
