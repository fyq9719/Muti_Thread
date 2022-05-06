/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : Bank.java
 * @createTime : 2022/4/26 19:31
 * @Description :
 */
public class Bank {

    public static void main(String[] args) {
        String s = "123";
        // String --> 基本数据类型
        int a = Integer.parseInt(s);
        // 基本数据类型 --> 包装类
        Integer integer = new Integer(a);
        // 包装类 --> String
        String s1 = integer.toString();
        // String --> 包装类
        Integer integer2 = Integer.valueOf(s1);
        // 包装类 --> 基本数据类型 装箱
        int a1 = integer2;
        // 基本数据类型 --> String
        String s3 = String.valueOf(a1);
    }




//    public String getSum(File dir){
//
//    }
}
