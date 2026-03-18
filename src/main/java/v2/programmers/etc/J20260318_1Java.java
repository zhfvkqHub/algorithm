package main.java.v2.programmers.etc;

import java.util.HashMap;
import java.util.Map;

/**
 * [Jabda]
 */
class J20260318_1Java {

    public int solution(String[] orders) {
        Map<String, Integer> priceMap = new HashMap<>();
        Map<String, Integer> quantityMap = new HashMap<>();

        for (String order : orders) {
            String[] parts = order.split(" ");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            int quantity = Integer.parseInt(parts[2]);

            priceMap.put(name, price);
            quantityMap.put(name, quantityMap.getOrDefault(name, 0) + quantity);
        }

        int totalAmount = 0;

        for (String name : quantityMap.keySet()) {
            int price = priceMap.get(name);
            int quantity = quantityMap.get(name);

            int amount = price * quantity;

            // 상품별 10% 할인
            if (quantity >= 3) {
                amount = (int) (amount * 0.9);
            }

            totalAmount += amount;
        }

        // 전체 주문 금액 5000원 이상이면 쿠폰 500원 할인
        if (totalAmount >= 5000) {
            totalAmount -= 500;
        }

        // 총 금액은 0원 미만 불가
        return Math.max(totalAmount, 0);
    }

    public static void main(String[] args) {
        // 각 주문은 "상품명 가격 수량" 형태의 문자열로 주어진다.
        // ["apple 1000 2", "banana 500 3", "apple 1000 1"]
        // 모든 주문을 합산하여 총 결제 금액을 반환 하는 함수를 작성하시오.
        // 같은 상품을 3개 이상 구매하면 해당 상품 총 금액에서 10% 할인을 적용한다.
        // 전체 주문이 5000원 이상이면 쿠폰 할인 500원을 적용한다.

        J20260318_1Java solution = new J20260318_1Java();
        String[] records = {"apple 1000 2", "banana 500 3", "apple 1000 1"};
        System.out.println(solution.solution(records));
    }
}
