package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test extends Thread {
    public static void main(String[] args) {
        //线程创建方式一:创建类继承Thread,重写run方法，再new对象调用start()
//        MyThread myThread = new MyThread();
//        myThread.start();
        //线程创建方式二：创建类，实现Runnable接口，重写run方法，new对象交给Thread，调用start()
//        MyRunnable myRunnable = new MyRunnable();
//        Thread myhread = new Thread(myRunnable);
//        myhread.start();
        //线程创建方式三：创建类实现Callable接口，重写call()，new对象交给FutureTask,再交给Thread，调用start()
        Mycallable mycallable = new Mycallable("11");
        FutureTask futureTask = new FutureTask<>(mycallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        Mycallable mycallable2 = new Mycallable("22");
        FutureTask futureTask2 = new FutureTask<>(mycallable2);
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        try {
            Object o = futureTask.get();
            System.out.println("o = " + o);
            Object o1 = futureTask2.get();
            System.out.println("o1 = " + o1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程：" + i);
        }
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程-：" + i);
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程-：" + i);
        }
    }
}

class Mycallable implements Callable{
    String s="";
public Mycallable(String s){
    this.s=s;
}
    @Override
    public Object call() throws Exception {
        return "子线程"+s;
    }
}