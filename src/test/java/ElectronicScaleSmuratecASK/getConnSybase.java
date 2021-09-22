package ElectronicScaleSmuratecASK;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class getConnSybase {

    /**
     * 连接数据库
     */
//    public static void main(String[] args) {
//
//        System.out.print(getConnSybase());
//    }
    public static Connection getConnSybase(String mess) {
        try {
            Connection conn;
            LocalDate date = LocalDate.now(); // get the current date
            LocalTime time = LocalTime.now(); // get the current time
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
//            InputStream path =Thread.currentThread().getContextClassLoader().getResourceAsStream("SocketDemo/analysis.properties");
//            VerboseDefaultConfig config = new VerboseDefaultConfig();
//            config.clear();
//            config.load(path);
//            jdbc.driver=com.sybase.jdbc4.jdbc.SybDriver
//            jdbc.url= jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK
//            jdbc.username=R200
//            jdbc.password=R200

            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);

//            String SQL = "BEGIN\n"
//                    + " SELECT * FROM CTL_TRANS "
//                    + "     ORDER BY NUM_UNIT\n"
//                    + "END";

//            update ELECTRONIC_SCALE set WEIGHT = '2' WHERE ip = '192.0.1.205'
            PreparedStatement pstmt = null;
            try {
                pstmt = conn
                        .prepareStatement("BEGIN\n" +"UPDATE ELECTRONIC_SCALE SET WEIGHT = ?,CREATE_TIME = ?,CREATE_DATE = ? WHERE ip = '192.0.1.205'\n"+ "END");
                pstmt.setString(1, mess);
                pstmt.setString(2, date.format(formatterDate));
                pstmt.setString(3, time.format(formatterTime));
                int rowcount = pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                e.printStackTrace();
            }
            pstmt.close();
            return null;
        }catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
