package serialPort;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SocketPort extends Thread {
    // 函数入口
    public static void main(String[] args) throws IOException {
        new SocketPort().start();
    }

    @Override
    public void run() {
        super.run();
        int i = 0;
        try {
            //使用PrintWriter和BufferedReader进行读写数据
            //创建一个Socket，跟服务器的8080端口链接
            Socket socket = new Socket("192.0.1.205",8010);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                i++;
                //发送数据
                pw.println("SIR".getBytes(StandardCharsets.UTF_8));
                pw.flush();
                //接收数据
                String line = is.readLine();
                if(line.length() > 10){
                    System.out.println(line);
                }
                Thread.sleep(5);
                if (i == 0){
                    break;
                }

            }
            //关闭资源
            pw.close();
            is.close();
            socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}