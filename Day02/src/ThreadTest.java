/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : ThreadTest.java
 * @createTime : 2022/4/21 15:14
 * @Description :
 */
public class ThreadTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        c1.setName("账户1");
        c2.setName("账户2");
        c1.start();
        c2.start();
    }
}

class Account{
    private double money;

    public Account(double money) {
        this.money = money;
    }


    public synchronized void  despoit(double value) {
        money += value;
        System.out.println(Thread.currentThread().getName() + ":存钱成功。余额为：" + money);
    }
}

class Customer extends Thread{
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.despoit(1000);
        }
    }
}