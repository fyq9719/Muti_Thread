import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : fyq
 * @version : 1.0
 * @Project : Muti_Thread
 * @Package : PACKAGE_NAME
 * @ClassName : .java
 * @createTime : 2022/5/2 9:48
 * @Description :
 */
public class TCPTest {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress name = InetAddress.getLocalHost();
            socket = new Socket(name, 8899);
            os = socket.getOutputStream();
            os.write("love u 3000".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                }
            }
        }
    }
    @Test
    public void server(){
        ServerSocket ss = null;
        InputStream is = null;
        Socket socket = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }

}
