package main.java.fastcampus.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 선택 정렬
 */
public class SelectionSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add((int) (Math.random()*100));
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(list);
    }

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        int lowest;
        for (int stand = 0; stand < dataList.size() - 1; stand++){
            lowest = stand;
            for (int idx = stand + 1; idx < dataList.size(); idx++){
                if(dataList.get(lowest) > dataList.get(idx))
                    lowest = idx;
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

}
