package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 同步线程
 */
public class SocketMain extends Thread {
    public static void main(String[] args) throws Exception {
        try {
            Socket s = new Socket("192.0.1.136",8001);
            //构建IO
            InputStream is = s.getInputStream();
            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (true){
                Thread.sleep(10);
                String mess = br.readLine();
                System.out.println("服务器："+mess);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
