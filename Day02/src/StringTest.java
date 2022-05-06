import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : StringTest.java
 * @createTime : 2022/4/22 9:58
 * @Description :
 */
public class StringTest {
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        System.out.println(sb1.length());
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }


    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";
        System.out.println(str);
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");// good
        System.out.println(ex.ch); // best
    }
}
