import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : Test.java
 * @createTime : 2022/4/26 19:11
 * @Description :
 */
public class Test extends SuperTest{
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;
        int c = 3;
        System.out.println(a==b);
        System.out.println(a==c);
        Map hashMap = new HashMap();
//        console
    }
//    public Long get(){
//        return new Long(5);
//    }

//    public int func(){
//        static int i = 0;
//        i ++ ;
//        return i;
//    }
}

class SuperTest{
    public Integer get(){
        return new Integer(4);
    }
}
