/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : EnumTest.java
 * @createTime : 2022/4/25 14:21
 * @Description :
 */
public class EnumTest {
    public static void main(String[] args) {
        Season season = Season.Spring;
        System.out.println(season.toString());
        Season[] values = season.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        System.out.println(Season.valueOf("Summer"));
        season.show();
    }
}

interface method{
    void show();
}

enum Season implements method{
    Spring("春天", "凉爽"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    Summer("夏天", "酷热"){
        @Override
        public void show() {
            System.out.println("夏天");
        }
    },
    Autum("秋天", "气爽"){
        @Override
        public void show() {
            System.out.println("秋天");
        }
    },
    Winter("冬天", "寒冷"){
        @Override
        public void show() {
            System.out.println("冬天");
        }
    };


    private final  String name;
    private final  String describe;

    Season(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }


}
