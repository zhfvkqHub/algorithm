package main.java.v2.programmers.lv1;

/**
 * [프로그래머스 Lv.1] 132267 - 콜라 문제
 * https://school.programmers.co.kr/learn/courses/30/lessons/132267?language=java
 */
class P132267Cola {
    // 교환 가능 a
    // 받는 개수 b
    // 콜라개수 n
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int exchange = n / a;
            int mod = n % a;

            int recive = exchange * b;
            answer += recive;
            n = recive + mod;
        }

        return answer;
    }

    public static void main(String[] args) {
        P132267Cola solution = new P132267Cola();
        System.out.println("answer :: " + solution.solution(2, 1, 20));
        System.out.println("answer2 :: " + solution.solution(3, 2, 20));
        System.out.println("answer3 :: " + solution.solution(10, 10, 10));
    }
}
