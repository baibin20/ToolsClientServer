package SocketDemo;

import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        try {
            System.out.println("服务端启动。。。。。。");
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(new Server_listen(socket)).start();
                new Thread(new Servrt_send(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
    }
}

class Server_listen implements Runnable{
    private Socket socket;

    Server_listen(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true){
                System.out.print("这是客户端传过来的：" + ois.readObject() + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Servrt_send implements Runnable{
    private Socket socket;

    Servrt_send(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.printf("服务端-请输入需要发送的数据:");
                String string = scanner.nextLine();
                oos.writeObject(string);
                oos.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
