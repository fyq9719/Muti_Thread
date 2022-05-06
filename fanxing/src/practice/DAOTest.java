package practice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : practice
 * @ClassName : .java
 * @createTime : 2022/4/27 15:46
 * @Description :
 */
public class DAOTest {
    public static void main(String[] args) {
        User u1 = new User(1001, 10, "zs");
        User u2 = new User(1002, 11, "ls");
        User u3 = new User(1003, 12, "ly");
        User u4 = new User(1004, 13, "yq");
        User u5 = new User(1001, 10, "ww");
        DAO<User> dao = new DAO<>();
        dao.save("1001", u1);
        dao.save("1002", u2);
        dao.save("1003", u3);
//        dao.show();
        List<User> list = dao.list();
        list.forEach(System.out::println);
//        System.out.println("---------");
//        System.out.println(dao.get("1002"));
    }
}
