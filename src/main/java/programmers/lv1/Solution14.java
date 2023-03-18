package main.java.programmers.lv1;

/**
 * 자연수 뒤집어 배열로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution14 Solution14 = new Solution14();
        Solution14.solution(12345);
    }

    public int[] solution(long n) {
        return new StringBuilder()
                .append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

}


