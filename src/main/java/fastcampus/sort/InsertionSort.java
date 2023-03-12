package main.java.fastcampus.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 삽입 정렬
 */
public class InsertionSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add((int) (Math.random()*100));
        }
        InsertionSort selectionSort = new InsertionSort();
        selectionSort.sort(list);
    }

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for (int idx = 0; idx < dataList.size() - 1; idx++){
            for (int idx2 = idx + 1; idx2 > 0; idx2--){
                if(dataList.get(idx2) < dataList.get(idx2 - 1))
                    Collections.swap(dataList, idx2, idx2 -1);
                else
                    break;
            }
        }
        return dataList;
    }

}
