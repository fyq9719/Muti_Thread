import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : ComparableTest.java
 * @createTime : 2022/4/25 11:25
 * @Description :
 */
public class ComparableTest {
    public static void main(String[] args) {
        Phone[] phones = new Phone[4];
        phones[0] = new Phone("HuaWei", 100);
        phones[1] = new Phone("XiaoMi", 80);
        phones[2] = new Phone("Iphone", 210);
        phones[3] = new Phone("Oppo", 180);
        Arrays.sort(phones);
        System.out.println(Arrays.toString(phones));
    }
    @Test
    public void test(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Phone && o2 instanceof Phone){
                    Phone phone1 = (Phone) o1;
                    Phone phone2 = (Phone) o2;
                    if (phone1.getName().equals(phone2.getName())){
                        return -Double.compare(phone1.getPrice(), phone2.getPrice());
                    }else{
                        return phone1.getName().compareTo(phone2.getName());
                    }
                }
                throw new RuntimeException();
            }
        };
        Phone[] phones = new Phone[5];
        phones[0] = new Phone("HuaWei", 100);
        phones[1] = new Phone("XiaoMi", 80);
        phones[2] = new Phone("Iphone", 210);
        phones[3] = new Phone("Oppo", 180);
        phones[4] = new Phone("Oppo", 190);
        Arrays.sort(phones, com);
        System.out.println(Arrays.toString(phones));
    }
}

class Phone implements Comparable {
    private String name;
    private double price;

    public Phone() {
    }

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Phone){
            Phone phone1 = (Phone) o;
            if (this.price > phone1.price){
                return 1;
            }else if (this.price < phone1.price){
                return -1;
            }else {
                return this.name.compareTo(phone1.name);
            }
        }
        throw new RuntimeException("输入数据非手机类型数据");
    }
}
