package cv.tools.tools.Service.SocketSer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Jrc6003 {
    public static void main(String args[]) throws Exception {

        ServerSocket server = new ServerSocket(6003);
        while (true) {
            Socket socket = server.accept();
            //每接收到一个Socket就建立一个新的线程来处理它
            new Thread(new Task(socket)).start();
        }
    }

    /**
     * 用来处理Socket请求的
     */
    static class Task implements Runnable{

        private Socket socket;


        public Task(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                handleSocket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 跟客户端Socket进行通信
         * @throws Exception
         */
        private void handleSocket() throws Exception {

            BufferedReader in=null;
            StringBuilder out = null;
            int len = 0;
            char chars[] = new char[1024];

            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream oos = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
            try{

                while ((len=in.read(chars)) != -1) {
                    StringBuilder sb = new StringBuilder();
                    out = sb.append(new String(chars, 0, len));
                    System.out.println("6003端口收到的内容：" + out);
                    Thread.sleep(1000);
                    bw.flush();
                }
            }catch (Exception exception){
                socket.close();
                System.out.println(exception.getMessage() + "\n");
            }
        }
    }
}