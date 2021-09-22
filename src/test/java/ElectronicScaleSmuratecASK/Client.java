package ElectronicScaleSmuratecASK;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket;
    public  static Boolean connection_state = false;
    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;

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
            socket = new Socket("192.0.1.205",8080);
            connection_state = true;
            InputStream is = socket.getInputStream();
            oos = new ObjectOutputStream(socket.getOutputStream());
//            ois = new ObjectInputStream(socket.getInputStream());
//            new Thread(new Client_listen(socket,ois)).start();
            new Thread(new Client_listen(socket,is)).start();
            new Thread(new Client_send(socket,oos)).start();
            new Thread(new Cliean_heard(socket,oos)).start();
        }catch (Exception e){
            e.printStackTrace();
            connection_state = false;
        }
    }

    public static void reconnect() throws IOException {
        while (!connection_state){
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
    private InputStream ois;
    getConnSybase getConnSybase = new getConnSybase();

    Client_listen(Socket socket,InputStream ois){
        this.socket = socket;
        this.ois = ois;
    }
    @Override
    public void run() {
        try{
            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(ois));
            while (true){
                Thread.sleep(1000);
                getConnSybase.getConnSybase(br.readLine());
//                System.out.printf("重量："+br.readLine()+"\n");
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
//            Scanner scanner = new Scanner(System.in);
            while (true){
//                System.out.printf("客户端-请输入需要发送的数据啊:");
//                String string = scanner.nextLine();
                oos.writeObject("S");
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
                oos.writeObject("S");
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


