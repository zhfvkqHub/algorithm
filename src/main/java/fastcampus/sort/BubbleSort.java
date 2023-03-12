package main.java.fastcampus.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 버블 정렬
 */
public class BubbleSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add((int) (Math.random()*100));
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(list);
    }

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for (int idx = 0; idx < dataList.size()-1; idx++){
            boolean swap = false;
            for (int idx2 = 0; idx2 < dataList.size() -1 -idx; idx2++){
                if(dataList.get(idx2) > dataList.get(idx2 + 1)){
                    Collections.swap(dataList, idx2, idx2 + 1);
                    swap = true;
                }
            }
            if (!swap)
                break;
        }
        return dataList;
    }

}
