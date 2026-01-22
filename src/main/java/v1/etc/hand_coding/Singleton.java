package main.java.v1.etc.hand_coding;

/**
 * Bill Pugh Singleton Implementation
 */
public class Singleton {
    private Singleton(){}

    private static class SingletonHelper{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
