package cv.tools.tools.Dao.Jobpalletbind;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class installJobPalletBind {
    private String memo2;
    private String memo3;
    private String memo4;
    private int qty;
    private String codeItem;

    public void install(List insJobPalletBindList){
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.136:2638/WMS_BBB";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);

            PreparedStatement pstm = conn.prepareStatement("insert into JOB_PALLETBIND values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            for (int i = 0; i < insJobPalletBindList.size(); i++) {
                Map mapList = (Map) insJobPalletBindList.get(i);
                Set<Map.Entry<Integer,String>> entries=mapList.entrySet();
                for (Map.Entry entry:entries){
                    if (entry.getKey().toString().equals("NUM_SEQ")){
                        pstm.setString(1, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("CODE_PALLET")){
                        pstm.setString(2, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("KIND")){
                        pstm.setString(3, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("PALLET_TYPE")){
                        pstm.setString(4, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("STS_PALLET")){
                        pstm.setString(5, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("NUM_QR")){
                        pstm.setString(6, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("CODE_ITEM")){
                        pstm.setString(7, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("LOT")){
                        pstm.setString(8, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("QTY")){
                        pstm.setString(9, String.valueOf(Integer.parseInt(entry.getValue().toString())));
                        qty = Integer.parseInt(entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("MEMO1")){
                        pstm.setString(10, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("MEMO2")){
                        pstm.setString(11, entry.getValue().toString());
                        memo2 = entry.getValue().toString();
                    }else if (entry.getKey().toString().toString().equals("MEMO3")){
                        pstm.setString(12, entry.getValue().toString());
                        memo3 = entry.getValue().toString();
                    }else if (entry.getKey().toString().equals("MEMO4")){
                        pstm.setString(13, entry.getValue().toString());
                        memo4 = entry.getValue().toString();
                    }else if (entry.getKey().toString().equals("MEMO5")){
                        pstm.setString(14, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("DATE_CRE")){
                        pstm.setString(15, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("TIME_CRE")){
                        pstm.setString(16, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("DATE_UPD")){
                        pstm.setString(17, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("TIME_UPD")){
                        pstm.setString(18, entry.getValue().toString());
                    }
                }
                this.updateSchStrpln(memo2,memo3,memo4,qty);
                pstm.addBatch();
            }
            pstm.executeBatch();
            conn.commit();
            stmt.close();
            pstm.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * 转换小数点
     */
    public int returnInt(Float qty,String codeItem){
        String select_qty = "";
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.136:2638/WMS_BBB";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT WEIGHT_DECIMAL_DIGITS FROM MST_ITEM WHERE CODE_ITEM = '" + codeItem +"'";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                select_qty = rs.getString(1);
            }
            stmt.close();
            BigDecimal b = new BigDecimal(qty);
            int f1 = (int) b.setScale(Integer.parseInt(select_qty),BigDecimal.ROUND_HALF_UP).floatValue();
            return f1;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return 0;
    }

    /**
     * 更新计划入库的组盘表
     * @param insJobPalletBindList
     */
    public void updateSchStrpln(String memo2,String memo3,String memo4,int qty) throws SQLException, ClassNotFoundException {
        try {
            ResultSet rs = null;
            List list = new ArrayList();
            Connection conn;
            String url = "jdbc:sybase:Tds:192.0.1.136:2638/WMS_BBB";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            PreparedStatement pstm = conn.prepareStatement("UPDATE SCH_STRPLN SET MEMO3 = MEMO3 - '"+qty+"' WHERE DATE_STRPLN = '"+memo2+"' AND NUM_ORDER = '"+memo3+"' AND NUM_DETAIL = '"+memo4+"'");
            pstm.executeUpdate();
            conn.commit();
            stmt.close();
            pstm.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
