import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : .java
 * @createTime : 2022/5/2 11:04
 * @Description :
 */
public class TCPIOTest {
    @Test
    public void clinet(){
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            socket = new Socket(address, 8899);
            File file = new File("1.png");
            fis = new FileInputStream(file);
            os = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len= fis.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
            socket.shutdownOutput();
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int lens;
            while ((lens = is.read(bytes)) != -1){
                baos.write(bytes, 0, lens);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if ( socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if ( fis != null){
                try {
                    fis.close();;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if ( os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if ( is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if ( baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os1 = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            OutputStream os = new FileOutputStream(new File("2.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ( (len = is.read(buffer)) != -1 ){
                os.write(buffer, 0, len);
            }
            System.out.println("接收完毕");
            os1 = socket.getOutputStream();
            os1.write("收到图片，质量很好，thank u".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if ( ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if ( socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if ( is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if ( os1 != null){
                try {
                    os1.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
