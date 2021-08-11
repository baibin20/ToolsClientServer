package qrCreate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class QrCodeTest {
    public static void main(String[] args) throws Exception {

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader("D:\\资料\\R200\\奥思康\\14_白斌\\QR码(手持扫码专用)\\物料条码.txt"));//构造一个BufferedReader类来读取文件
            String s = null;
            int num = 0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                ++num;
//                System.out.println(s);
                //生成二维码 String str1=str.substring(0, str.indexOf("?"));
                QRCodeUtil.encode(s, "D:\\资料\\R200\\奥思康\\14_白斌\\QR码(手持扫码专用)\\中间的图片.png", "D:\\资料\\R200\\奥思康\\14_白斌\\QR码(手持扫码专用)\\生成的二维码\\"+ s.substring(0,s.indexOf("|")) + "-" +num + ".jpg", true);
            }
            System.out.println("生成完成");
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
