package main.java.inflearn;

import java.util.Scanner;

public class SlidingWindow {

    public static void main(String[] args) {
        SlidingWindow T = new SlidingWindow();
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(T.solution(n, k, arr));
        
    }

    private int solution(int n, int k, int[] arr) {
        int answer=0, sum=0;

        for(int i=0; i<k; i++)
            sum += arr[i];

        for(int i=k; i<n; i++){
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

}
