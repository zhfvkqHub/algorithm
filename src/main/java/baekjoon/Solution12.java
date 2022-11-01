package main.java.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2655 가장 높은 탑
public class Solution12 {

    static public class Block implements Comparable<Block>{
        int num;
        int area, height, weight;

        public Block(int num,int area, int height, int weight){
            this.num = num;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block o) {

            if(this.area == o.area) {
                return o.weight - this.weight;
            }

            return o.area - this.area;
        }
    }

    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        Block[] blocks = new Block[N+1];

        dp = new int[N+1];
        arr = new int[N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken(" "));
            int height = Integer.parseInt(st.nextToken(" "));
            int weight = Integer.parseInt(st.nextToken(" "));

            blocks[i] = (new Block(i,area,height,weight));
        }

        blocks[0] = new Block(0,1000000,0,999999999);
        Arrays.sort(blocks);

        for(int i=0;i<=N;i++) {
            dp[i] = -1;
            arr[i] = -1;
        }

        int result = solve(0, N, blocks);
        print(arr[0], 0,blocks);


    }
    static int solve(int num, int N, Block[] blocks) {

        if(dp[num] != -1) {
            return dp[num];
        }

        int now = blocks[num].height;

        for(int i=num+1;i<=N;i++) {
            if(blocks[num].weight > blocks[i].weight && now < blocks[num].height + solve(i,N,blocks)) {
                now = blocks[num].height + solve(i,N,blocks);
                arr[num] = i;
            }
        }

        return dp[num] = now;

    }

    static void print(int n, int cnt, Block[] blocks) {
        if(n == - 1) {
            System.out.println(cnt);
            return;
        }

        print(arr[n], cnt+1,blocks);
        System.out.println(blocks[n].num);
    }


}
