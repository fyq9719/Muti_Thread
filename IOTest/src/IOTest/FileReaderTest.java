package IOTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : IOTest
 * @ClassName : .java
 * @createTime : 2022/4/29 15:38
 * @Description :
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            File file = new File("IOTest\\HelloWorld1.txt");
            fileReader = new FileReader(file);
            int data;
            while ((data=fileReader.read())!= -1){
                System.out.print((char) data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            }


    }
}
