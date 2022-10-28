package main.java.programmers.lv2;

// N개의 최소공배수
public class Solution8 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        solution8.solution(new int[]{2,6,8,14});

    }

    public long solution(int[] arr) {
        long answer = 1;

        for (int i = 0; i < arr.length; i++) {

            long g = gcd(arr[i], answer);
            answer = arr[i] * answer / g;

        }
        return answer;
    }

    // 최대공약수
    long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

}
