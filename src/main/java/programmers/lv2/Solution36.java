package main.java.programmers.lv2;

// LV2 타겟 넘버
public class Solution36 {

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        solution36.solution(new int[]{1, 1, 1, 1, 1}, 3);
    }


    static int ans, goal, n, num[], cache[];

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        num = numbers;
        cache = new int[n];
        goal = target;

        dfs(0);

        return ans;
    }

    static void dfs (int depth) {

        if (depth == n) {
            int sum = 0;

            for (int a : cache)
                sum += a;

            if (sum == goal)
                ans++;

            return;
        }

        cache[depth] = - num[depth];
        dfs(depth + 1);
        cache[depth] = num[depth];
        dfs(depth + 1);
    }
}


