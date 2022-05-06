import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : UniqueList.java
 * @createTime : 2022/4/26 14:31
 * @Description :在List内去除重复数字值，要求尽量简单
 */
public class UniqueList {
    public static void main(String[] args) {
        List list = new ArrayList();


        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));

        HashSet set = new HashSet();

        for (int i = list.size()-1; i >= 0; i--) {
            Object o = list.get(i);
            if (set.contains(o)){
                list.remove(i);
            }else{
                set.add(o);
            }
        }
        System.out.println(list);
    }
    @Test
    public void test(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(6));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(3));
        Object[] array = list.toArray();
        Arrays.sort(array);
        for (Object o: array
             ) {
            System.out.println(o);
        }

    }
}
