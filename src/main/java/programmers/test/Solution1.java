package main.java.programmers.test;

// N개의 최소공배수
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.solution(new int[][]{{0,0,0,0,0},{0,0,0,0,0},{2,2,0,0,0},{1,0,1,0,0},{2,1,2,2,2},{2,1,2,2,2}});

    }

    public int solution(int[][] histogram) {
        int answer = 1;
        // 방문 기록
        boolean[] visited = new boolean[histogram[0].length];
        // 경우의 수
        int[] caseCnt = new int[histogram[0].length];

        for(int i=0; i<histogram.length; i++){
            int[] hi = histogram[i];

            for(int j=0; j< hi.length; j++){
                int h = hi[j];

                if(h == 0){
                    caseCnt[j] = 0;
                    continue;
                }

                if(!visited[j]){
                    if(h == 1){
                        caseCnt[j] += 1;
                        visited[j] = true;
                    }else if(h == 2){
                        if(i+1 == histogram.length){ // 마지막 라인
                            caseCnt[j] += 2;
                        }else{
                            caseCnt[j] += 1;
                        }
                    }
                }
            }

        }

        for(int cnt : caseCnt){
            if(cnt == 0) cnt = 1;
            answer *= cnt;
        }

        System.out.println(answer);
        return answer;
    }


}
