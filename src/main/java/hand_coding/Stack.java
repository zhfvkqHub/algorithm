package main.java.hand_coding;

/**
 * FILO
 */
public class Stack {
    private static int MAX_STACK_SIZE = 10;
    private int top;
    private int[] data = new int[MAX_STACK_SIZE];

    public Stack(){
        top = -1;
    }

    /**
     * 스택 값 추가
     * @param data_
     * @throws Exception
     */
    public void push(int data_) throws Exception{
        if(isFull()){
            throw  new Exception("스택이 가득 찼습니다.");
        }
        data[++top] = data_;
    }

    /**
     * 스택 값 제거
     * @return
     * @throws Exception
     */
    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("스택이 비었습니다.");
        }
        return data[top--];
    }

    /**
     * 스택 상단 값 출력
     * @return
     * @throws Exception
     */
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("스택이 비었습니다.");
        }
        return data[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == MAX_STACK_SIZE -1;
    }

    /**
     * 스택 사이즈 출력
     * @return
     */
    public int size(){
        return top + 1;
    }

}
