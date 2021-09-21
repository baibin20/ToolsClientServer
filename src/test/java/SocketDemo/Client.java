package SocketDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    public  static Boolean connection_state = false;
    private static ObjectOutputStream oos;

    public static void main(String[] args) throws IOException {
        while (!connection_state){
            connect();
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    private static void connect() throws IOException {
        try{
            socket = new Socket("127.0.0.1",8888);
            connection_state = true;
            oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            new Thread(new Client_listen(socket,ois)).start();
            new Thread(new Client_send(socket,oos)).start();
            new Thread(new Cliean_heard(socket,oos)).start();
        }catch (Exception e){
            e.printStackTrace();
            connection_state = false;
        }
    }

    public static void reconnect() throws IOException {
        while (!connection_state){
//            System.out.println("正在尝试重新连接");
            connect();
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Client_listen implements Runnable{

    private Socket socket;
    private ObjectInputStream ois;

    Client_listen(Socket socket,ObjectInputStream ois){
        this.socket = socket;
        this.ois = ois;
    }
    @Override
    public void run() {
        try{
            while (true){
                System.out.print(ois.readObject() + "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Client_send implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;
    Client_send(Socket socket,ObjectOutputStream oos){
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try{
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.printf("客户端-请输入需要发送的数据:");
                String string = scanner.nextLine();
                oos.writeObject(string);
                oos.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Cliean_heard implements Runnable{
    private Socket socket;
    private ObjectOutputStream oos;
    Cliean_heard(Socket socket,ObjectOutputStream oos){
        this.socket = socket;
        this.oos = oos;
    }

    @Override
    public void run() {
        try{
            System.out.printf("心跳包线程启动");
            while (true){
                Thread.sleep(5000);
                oos.writeObject(123);
                oos.flush();
            }
        }catch (Exception e ){
            e.printStackTrace();
            try {
                socket.close();
                Client.connection_state = false;
                Client.reconnect();
            }catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}


