package serialPort.fileDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class serialPort extends Thread{
    public void run(){
        try {
            int i = 0;
            BufferedWriter out = new BufferedWriter(new FileWriter("D:\\Tools\\AutoDebugTools\\ToolsClientServer\\ToolsClientServer\\src\\test\\java\\serialPort\\fileDemo\\1.txt"));
            while (true){
                i++;
                out.write("菜鸟教程");
                Thread.sleep(5);
                if (i == 0){
                    break;
                }
            }
            out.close();
        }catch (Exception ex){
            System.out.println("错误");
        }
    }

    public static void run1() {
        new serialPort().start();
    }
}
