package BufferTest;

import java.io.*;
import java.util.HashMap;

import static java.lang.System.currentTimeMillis;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : BufferTest
 * @ClassName : .java
 * @createTime : 2022/4/29 16:54
 * @Description :
 */
public class BufferTest {

    public static void main(String[] args) {
        String srcPath = "F:\\BaiduNetdiskDownload\\[机智牢房生活][2017][全集][韩剧]\\video.mp4";
        String desPath = "F:\\BaiduNetdiskDownload\\[机智牢房生活][2017][全集][韩剧]\\video1.mp4";
        String desPath1 = "F:\\BaiduNetdiskDownload\\[机智牢房生活][2017][全集][韩剧]\\video2.mp4";
        BufferTest bufferTest = new BufferTest();

        long s1 = currentTimeMillis();
        bufferTest.copyNorm(srcPath, desPath);
        long s2 = currentTimeMillis();
        System.out.println(s2-s1);

        long s3 = currentTimeMillis();
        bufferTest.copyBuffer(srcPath, desPath1);
        long s4 = currentTimeMillis();
        System.out.println(s4-s3);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 2);
        map.put("2", 1);
//        Collections.sort(map);
    }

    public void copyNorm(String srcPath, String desPath){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            File srcFile = new File(srcPath);
            File desFile = new File((desPath));

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(desFile);

            byte[] bytes = new byte[1024];
            int len;
            while ((len=fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public void copyBuffer(String srcPath, String desPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File srcFile = new File(srcPath);
            File desFile = new File((desPath));

            FileInputStream fileInputStream = new FileInputStream(srcFile);
            FileOutputStream fileOutputStream = new FileOutputStream(desFile);

            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
