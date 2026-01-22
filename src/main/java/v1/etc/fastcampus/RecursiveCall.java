package main.java.v1.etc.fastcampus;

public class RecursiveCall {
    public static void main(String[] args) {
        RecursiveCall recursiveCall = new RecursiveCall();
        System.out.println(recursiveCall.factoryFunc(7));

    }

    public int factoryFunc(int n){
        if(n>1){
            return n * this.factoryFunc(n-1);
        }else{
            return 1;
        }
    }

}
