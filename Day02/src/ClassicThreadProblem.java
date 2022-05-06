/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : ClassicThreadProblem.java
 * @createTime : 2022/4/21 16:37
 * @Description :
 */
public class ClassicThreadProblem {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Cust c = new Cust(clerk);
        p.setName("第一个生产者");
        c.setName("第一个消费者");
        p.start();
        c.start();
    }
}

class Clerk{
    private int good;

    public synchronized void add(){
        if (good < 20){
            good += 1;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + good + "个产品");
            notify();
        } else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public synchronized void buy(){
        if (good > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + good + "个产品");
            good -= 1;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
// 疑问：如果通过wait来控制buy和add: 设置两个同步方法，使用synchronized来控制买和卖

}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
       while (true){
           clerk.add();
       }
    }
}

class Cust extends Thread{
    private Clerk clerk;

    public Cust(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            clerk.buy();
        }
    }
}
