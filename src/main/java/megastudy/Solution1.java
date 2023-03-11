package main.java.megastudy;

public class Solution1 {

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        solution1.gugudanFor();
        solution1.gugudanWhile();
        solution1.guguandNoIf();

        solution1.swap1();
        solution1.swapXOR();

    }


    /**
     * 구구단 2~9단 출력
     * -- 반복문을 1회만 사용
     */
    private void gugudanFor() {
        int dan = 2;
        int num = 1;
        int result;

        for (int i = 1; i <= 72; i++) {
            result = dan * num;
            System.out.printf("%d x %d = %d\n", dan, num, result);
            num++;

            if (num > 9) {
                dan++;
                num = 1;
                System.out.println();
            }
        }
    }

    private void gugudanWhile(){
        int dan = 2;
        int num = 1;

        while (dan <= 9) {
            System.out.printf("%d x %d = %d\n", dan, num, dan*num);
            if (num == 9) {
                num = 1;
                dan++;
                System.out.println();
            }
            else num++;
        }
    }

    // 조건문 사용 하지 않기
    private void guguandNoIf() {
        int j, k;
        for (int i = 18; i < 90; i++) {
            j = i / 9;
            k = i % 9 + 1;
            System.out.printf("%d x %d = %d\n", j, k, j*k);

            if(k == 9) System.out.println();
        }
    }

    /**
     * 두 변수의 값을 서로 교환
     * -- 추가 변수 사용 하지 말기
     */
    private void swap1(){
        int a = 15;
        int b = 10;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private void swapXOR(){
        int a = 15;
        int b = 10;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}
