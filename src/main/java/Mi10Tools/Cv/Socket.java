package Mi10Tools.Cv;

import org.apache.commons.lang.StringUtils;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.security.core.parameters.P;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ServerSer {
    public static String serMessage;
    public static int flag = 0;
    /**
     * DO的头报文
     */
    private  static final String doTitle = "5000";        // サブヘッダ
    private  static final String doInter = "00";          // ネットワーク番号
    private  static final String doPcNum = "FF";        // PC番号
    private  static final String doUnitNum = "03FF";      // 要求先ユニットI/0番号
    private  static final String doReqNum = "00";       // 要求先ユニット　　局番号
    private  static final String doDataLeg = "0090";      // 要求データ長    可变长度
    private  static final String doCpuTime = "0010";      // CPU監視タイマ
    private  static final String doCommand = "1401";      // コマンド
    private  static final String doSubcommand = "0000";   // サブコマンド
    private  static final String doDeviceCode = "D*";   // デバイスコード
    private  static final String doLeadDevice = "000100";   // 先頭デバイス
    private  static final String doDeviceScore = "001E";  // デバイス点数

    /**
     * DI的报文头
     */
    private  static final String diTitle = "D000";        // サブヘッダ
    private  static final String diInter = "00";          // ネットワーク番号
    private  static final String diPcNum = "FF";        // PC番号
    private  static final String diUnitNum = "03FF";      // 要求先ユニットI/0番号
    private  static final String diReqNum = "00";       // 要求先ユニット　　局番号
    private  static final String diDataLeg = "007C";      // 要求データ長    可变长度
    private  static final String diCpuTime = "0000";      // 終了コード
    private  static final String diSubcommand = "0000";   // サブコマンド

    public static void main(String args[]) throws Exception {
        //为了简单起见，所有的异常信息都往外抛
        int port = 8001;
        //定义一个ServerSocket监听在端口8899上
        //ServerSocket server = new ServerSocket(port);
        ServerSocket server = new ServerSocket(8001);

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
            String write = "D00000FF03FF00007C0000000000000000000000000000000300000000000000030000000000000003000000000000000300000000000000030000000000000003000000000000";
            String write1 = "";
            String write2 = "D00000FF03FF0000040000";
            String send = "D00000FF03FF00007C0000000000000000000000000000";
            BufferedReader in=null;
            StringBuilder out = null;
            String stringid;
            int len = 0;
            int len1 = 0;
            char chars[] = new char[1024];

            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream oos = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
            try{

                while ((len=in.read(chars)) != -1) {
                    StringBuilder sb = new StringBuilder();
                    out = sb.append(new String(chars, 0, len));
                    //System.out.println("come on" + out);
//                    System.out.println(out.toString());
                    len1 = out.length();
                    if (len1 > 42) {
                        serMessage = "";
                        //MI10会有一条DO请求过来这个时候需要给MI10回答DO的长度等，此报文固定
                        serMessage = out.toString();
                        //Thread.sleep(20);
                        //new Conversion().conversion(out.toString());
                        bw.write(String.valueOf(write2));
                    } else if (out.toString().length() == 42) {
                        String serMessage3 = serMessage;
                        // 处理发送的Di  flag
                        if (serMessage3 != null) {
                            String str = serMessage3.substring(66, serMessage.length()).substring(0, 4);
                            if (str.equals("0001")) {
                                flag = 1;
                                write1 = "002320000000000000232000000000000023200000000000002320000000000000232000000000000023200000000000";
                            } else if (str.equals("0402")) {
                                flag = 2;
                                write1 = "002320000000000000232000000000000023200000000000002320000000000000232000000000000023200000000000";
                            } else if (flag == 1) {
                                write1 = "";
                                write1 = "022320000000000002232000000000000223200000000000022320000000000002232000000000000223200000000000";
                            } else if (flag == 2 || flag == 0) {
                                write1 = "012320000000000001232000000000000123200000000000012320000000000001232000000000000123200000000000";
                            }
                        } else {
                            write1 = write;
                        }
                        if(serMessage3 == null){
                            bw.write(write1);
                        }else{
                            bw.write(send + write1);
                        }
                    }
                    Thread.sleep(300);
                    bw.flush();
                }
            }catch (Exception exception){
                socket.close();
                System.out.println(exception.getMessage() + "\n");
            }
        }
    }
    private static class Conversion{
        public void conversion(String resMessage){
            List list = new ArrayList();
            StringBuffer result = new StringBuffer();
            String count = "";
            String bb = resMessage.trim();
            String cc = bb.substring(42,bb.length());
            for (int i = 0; i < cc.length(); i++) {
                count=Integer.toBinaryString(cc.charAt(i)).substring(2,6);
                list.add(count);
            }
        }
    }
}