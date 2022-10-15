package main.java.solution;

import java.io.IOException;
import java.util.*;

// 씨름 선수 => 클래스 만들어서 정렬해야됨.
// 그리디 알고리즘 => 현재에서 최선의 선택
public class Solution5 {
    static class Body implements Comparable<Body>{
        int length,weight;

        public Body(int length, int weight) {
            this.length = length;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.length - this.length; // 내림차순
        }
    }

   public static int solution(ArrayList<Body> arr, int n){
       int cnt = 0;
       Collections.sort(arr); //compareTo을 이용하여 내림차순 정렬
       int max = Integer.MIN_VALUE;

       for(Body ob : arr){
           if(ob.weight>max){
               max = ob.weight;
               cnt ++;
           }
       }
       return cnt;
   }

   public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            int l = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(l,w));
        }

       System.out.println(solution(arr, n));

   }

}
