package main.java.programmers.lv2;

// LV2 피로도
public class Solution24 {
    public static void main(String[] args) {
        Solution24 solution23 = new Solution24();
        solution23.solution(80, new int[][]{{80,20},{50,40},{30,10}});
    }

    public static boolean check[];
    public static int ans = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return ans;
    }
    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=tired){
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
}
