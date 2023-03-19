package main.java.hand_coding;

import java.util.ArrayList;

/**
 * FIFO
 */
public class Queue<T> {
    private ArrayList<T> queue = new ArrayList<>();

    public void enqueue(T item){
        queue.add(item);
    }

    public T dequeue(){
        if(queue.isEmpty())
            return null;

        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> Q = new Queue<>();
        Q.enqueue(1);
        Q.enqueue(2);
    }

}
