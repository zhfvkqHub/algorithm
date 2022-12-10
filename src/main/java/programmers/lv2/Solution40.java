package main.java.programmers.lv2;

import java.util.*;

// LV2 완전탐색 > 전력망을 둘로 나누기
public class Solution40 {

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        solution40.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
    }

    public class Node{
        int index;
        int num;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<Node> arr[] = new ArrayList[n+1];

        for(int i=0; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            arr[wires[i][0]].add(new Node(wires[i][1],i));
            arr[wires[i][1]].add(new Node(wires[i][0],i));
        }

        for(int i=0; i<n-1; i++){
            boolean visited[] = new boolean[n+1];

            Queue<Integer> q =new LinkedList<>();
            q.add(1);
            visited[1]=true;
            int cnt=1;
            while(!q.isEmpty()){
                int nowIndex = q.poll();

                for(Node nextNode : arr[nowIndex]){
                    if(nextNode.num == i || visited[nextNode.index]){
                        continue;
                    }

                    q.add(nextNode.index);
                    visited[nextNode.index]=true;
                    cnt++;

                }
            }
            answer=Integer.min(answer,Math.abs(n-cnt-cnt));
        }
        return answer;
    }

}


