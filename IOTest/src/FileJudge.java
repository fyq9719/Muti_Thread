import org.junit.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : .java
 * @createTime : 2022/4/29 11:21
 * @Description :
 */
public class FileJudge {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\jd\\Desktop");
        String[] list = file.list();
        for (String s:list
             ) {
            if (s.contains(".jpg")){
                System.out.println(s);
            }
        }
    }

    @Test
    public void test(){
        File file = new File("C:\\Users\\jd\\Desktop");
        showFile(file);

    }

    public void showFile(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                System.out.println(file1);
                showFile(file1);
            }else {
                System.out.println(file1);
            }
        }
    }

//    public void test1{
//
//    }
    @Test
    public void test2(){
        File file = new File("C:\\Users\\jd\\Desktop\\新建文件夹");
        delete(file);
    }

    public void delete(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                delete(file1);
                file1.delete();
            }else{
                file1.delete();
            }
        }
        file.delete();
    }
}
