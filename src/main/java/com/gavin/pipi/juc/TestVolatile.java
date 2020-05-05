package com.gavin.pipi.juc;

/**
 * volatile关键字可以是的多个线程操作共享变量时保持内存的可见性
 * 另外可以避免jvm的指令重排序
 * @date 2020/5/5 21:10
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while (true){
            if(td.isFlag()){
                System.out.println("-----------");
                break;
            }
        }
    }
}
class ThreadDemo implements Runnable{

    //private boolean flag = false;
    //使用volatile关键字，可以使子线程中对flag的修改可以立马刷新到主存中，main线程可以立即读到刷新后的值，从而终止死循环
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag="+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

}
