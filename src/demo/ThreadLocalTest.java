package demo;

import java.util.concurrent.Executors;


public class ThreadLocalTest {
    public ThreadLocalTest() {
    }

    public static void main(String[] args) {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("lllll");
        ThreadLocal<String> threadLocal = new ThreadLocal();
        threadLocal.set("abc");
        System.out.println(threadLocal.get());
        Executors.newCachedThreadPool().execute(() -> {
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
            Executors.newCachedThreadPool().execute(() -> System.out.println(inheritableThreadLocal.get() + "========="));
        });
    }
}

