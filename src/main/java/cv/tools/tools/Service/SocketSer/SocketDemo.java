package cv.tools.tools.Service.SocketSer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SocketDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            //创建一个ServerSocket监听8080端口
            ServerSocket server = new ServerSocket(8080);
            //等待请求
            Socket socket = server.accept();
            //接受请求后使用Socket进行通信，创建BufferedReader用于读取数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("received frome client:" + line);
            //创建PrintWriter，用于发送数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("this data is from server");
            pw.flush();
            //关闭资源
            pw.close();
            is.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

