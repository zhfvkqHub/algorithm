package main.java.programmers.lv3;

/**
 * 단어 변환 (DFS/BFS)
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Solution11 {

    public static void main(String[] args) {
        Solution11 Solution11 = new Solution11();
        Solution11.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }

    static int answer = 51;

    public int solution(String begin, String target, String[] words) {
        boolean[] check = new boolean[words.length];

        dfs(begin, target, words, 0, check);

        if(answer == 51)
            answer = 0;

        return answer;
    }
    static void dfs(String begin, String target, String[] words, int cnt, boolean[] check){

        if(begin.equals(target)){
            if(answer > cnt)
                answer = cnt;
            return;
        }

        for(int i = 0; i < words.length; i++){
            int diff = 0;

            for(int j = 0; j < begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j))
                    diff++;
            }

            if(!check[i] && diff == 1){
                check[i] = true;
                dfs(words[i], target, words, cnt+1, check);
                check[i] = false;
            }
        }
    }

}



