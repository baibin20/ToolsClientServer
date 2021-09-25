package cv.tools.tools.Dao.Jobpalletbind;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class installJobPalletBind {

    public void install(List insJobPalletBindList){
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            PreparedStatement pstm = null;
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();

            for (int i = 0; i < insJobPalletBindList.size(); i++) {
                Map mapList = (Map) insJobPalletBindList.get(i);
                Set<Map.Entry<Integer,String>> entries=mapList.entrySet();
                pstm = conn.prepareStatement("insert into student values(?,?,?,?)");
                for (Map.Entry entry:entries){
                    pstm.setString(1, "entry.getValue()");
                    System.out.println(entry.getValue());
                }
            }


            pstm = conn.prepareStatement("insert into student values(?,?,?,?)");
            conn.setAutoCommit(false);//1,首先把Auto commit设置为false,不让它自动提交
            // 2) 设置sql语句1
            pstm.setInt(1, 33);
            pstm.setString(2,"wangqin");
            pstm.setString(3, "c++");
            pstm.setDouble(4, 78.5);
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。
            pstm.addBatch();
            // 2) 设置sql语句2
            pstm.setInt(1, 34);
            pstm.setString(2,"wuytun");
            pstm.setString(3, "c");
            pstm.setDouble(4, 77);
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。
            pstm.addBatch();
            // 2) 设置sql语句3
            pstm.setInt(1, 31);
            pstm.setString(2,"tetet");
            pstm.setString(3, "c++");
            pstm.setDouble(4, 90);
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。
            pstm.addBatch();
            // 2) 设置sql语句4
            pstm.setInt(1, 32);
            pstm.setString(2,"liug");
            pstm.setString(3, "c");
            pstm.setDouble(4, 50);
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。
            pstm.addBatch();



































            // 4) 将一批参数提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。
            pstm.executeBatch();
            System.out.println("插入成功！");
            // 若成功执行完所有的插入操作，则正常结束
            con.commit();//2,进行手动提交（commit）
            System.out.println("提交成功!");
            con.setAutoCommit(true);//3,提交完成后回复现场将Auto commit,还原为true,










































            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
            stmt.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
