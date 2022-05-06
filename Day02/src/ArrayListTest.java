import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : ArrayListTest.java
 * @createTime : 2022/4/26 10:11
 * @Description :
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Collection arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(234);
        arrayList.add(456);
        arrayList.add(789);
        System.out.println(arrayList);
        for (Object num:arrayList
             ) {
            num = 988;
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test1(){
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println(str);
    }

}
