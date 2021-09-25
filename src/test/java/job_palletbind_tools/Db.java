package job_palletbind_tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Db {
    private static Object String;

    /**
     * 连接数据库
     */
    public static void main(String[] args) {
        List list = getConnSybase();
        for (int i = 0; i < list.size(); i++) {
            Map mapList = (Map) list.get(i);
            Set<Map.Entry<Integer,String>> entries=mapList.entrySet();
            for (Map.Entry entry:entries){
                System.out.println(entry.getKey() +"\t" + entry.getValue());
            }
        }
    }
    public static List  getConnSybase() {
        Map map = new HashMap();
        List list = new ArrayList();
        try {
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.136:2638/WMS_BBB";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);

            String SQL = "BEGIN\n"
                    + " SELECT * FROM JOB_QRPRINTING "
                    + "     ORDER BY NUM_QR\n"
                    + "END";

            Statement stmt = conn.createStatement();
            if( stmt.execute(SQL) )
            {
                int i = 0;
                ResultSet rs = stmt.getResultSet();
                while( rs != null )
                {
                    while (rs.next())
                    {
                        map.put("NUM_QR",rs.getString(1));
                        map.put("STS_QR",rs.getString(2));
                        map.put("CODE_ITEM",rs.getString(3));
                        map.put("LOT",rs.getString(4));
                        map.put("QTY",rs.getString(5));
                        map.put("RESIN_NAME",rs.getString(6));
                        map.put("NUM_COLOR",rs.getString(7));
                        map.put("NUM_BAGS_START",rs.getString(8));
                        map.put("NUM_BAGS_END",rs.getString(9));
                        map.put("CODE_QR",rs.getString(10));
                        map.put("MEMO1",rs.getString(11));
                        map.put("MEMO2",rs.getString(12));
                        map.put("MEMO3",rs.getString(13));
                        map.put("MEMO4",rs.getString(14));
                        map.put("MEMO5",rs.getString(15));
                        map.put("MEMO6",rs.getString(16));
                        map.put("MEMO7",rs.getString(17));
                        map.put("MEMO8",rs.getString(18));
                        map.put("MEMO9",rs.getString(19));
                        map.put("MEMO10",rs.getString(20));
                        map.put("DATE_CRE",rs.getString(21));
                        map.put("TIME_CRE",rs.getString(22));
                        map.put("DATE_UPD",rs.getString(23));
                        map.put("TIME_UPD",rs.getString(24));
                        list.add(map);
//                        System.out.println(rs.getString(1)
//                                + ", " + rs.getString(2)
//                                + ", " + rs.getString(3) );
                    }
                    if( stmt.getMoreResults() )
                    {
                        rs = stmt.getResultSet();
                    }
                    else
                    {
                        rs.close();
                        rs = null;
                    }
                }
            }
            stmt.close();
            return list;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
