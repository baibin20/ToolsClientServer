package cv.tools.tools.Dao.Jobpalletbind;

import breeze.collection.mutable.ArrayMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findInstallJpbpPalletBindDao {
    /**
     * 查询出物料类别
     */
    public List findCodeCategry() {
        try {
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);

            String SQL = "BEGIN\n"
                    + " SELECT MI.CODE_CATEGRY,MC.NAME_CATEGRY "
                    + "FROM MST_ITEM MI,MST_CTGRY MC\n"
                    + "WHERE MI.CODE_CATEGRY = MC.CODE_CATEGRY\n"
                    + "GROUP BY MI.CODE_CATEGRY,MC.NAME_CATEGRY\n"
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
                        Map map = new HashMap();
                        map.put("code_categry",rs.getString(1));
                        map.put("name_categry",rs.getString(2));
                        list.add(map);
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

    /**
     * 查询出保管区域  CODE_STORAGE
     */
    public List findCodeStorage() {
        try {
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);

            String SQL = "BEGIN\n"
                    + " SELECT MI.CODE_STORAGE,DC.NAME_ITEM_DATA \n"
                    + "FROM DEF_COMN DC,MST_ITEM MI \n"
                    + "WHERE DC.id_item = 'code_storage_area' AND MI.CODE_STORAGE = DC.DATA_ITEM\n"
                    + "Group By MI.CODE_STORAGE,DC.NAME_ITEM_DATA\n"
                    + "ORDER BY MI.CODE_STORAGE\n"
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
                        Map map = new HashMap();
                        map.put("code_storage",rs.getString(1).replace("^",""));
                        map.put("name_item_data",rs.getString(2).replace("^",""));
                        list.add(map);
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


    /**
     * 查询QRcode
     */
    public List findQrCode(String startData,String startTime,String endData,String endTime) {
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT CODE_QR from JOB_QRPRINTING where DATE_CRE >= '" + startData + "' AND DATE_CRE <= '"+endData+"' AND TIME_CRE >= '"+startTime+"' AND TIME_CRE <= '"+endTime+"' AND MEMO2 = '1' ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            stmt.close();
            return list;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    /**
     * 根据品号查找托盘类型，保管仓库
     */
    public List findQrCode(String codeItem) {
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT RIGHT(CODE_CATEGRY,1),CODE_STORAGE FROM MST_ITEM where CODE_ITEM = '"+codeItem+"'";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
            }
            stmt.close();
            return list;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    /**
     * 根据品号批号查找对应的单号子单号入库时间
     */
    public List findSchStrpln(String qrCode) {
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.202:2638/WMS_ASK";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT SS.NUM_ORDER,SS.NUM_DETAIL,SS.DATE_STRPLN FROM SCH_STRPLN SS,JOB_QRPRINTING JQ where JQ.NUM_QR = '"+qrCode+"' AND JQ.MEMO8 = SS.NUM_ORDER AND JQ.MEMO9 = SS.NUM_DETAIL AND SS.MEMO3 <> '0'";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
            }
            stmt.close();
            return list;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
