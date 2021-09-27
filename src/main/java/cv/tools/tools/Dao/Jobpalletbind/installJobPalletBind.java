package cv.tools.tools.Dao.Jobpalletbind;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class installJobPalletBind {
    private String memo3;
    private String memo4;
    private int qty;
    private String codeItem;

    public void install(List insJobPalletBindList){
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
            conn.setAutoCommit(false);

            PreparedStatement pstm = conn.prepareStatement("insert into JOB_PALLETBIND values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement pstmt1 = conn
                    .prepareStatement("BEGIN\n" + "UPDATE SCH_STRPLN SET MEMO3 = MEMO3 - (SELECT CONVERT(DECIMAL(12,0),FLOOR(CONVERT(FLOAT,?) * POWER(10, ?)))) WHERE NUM_ORDER = ? AND NUM_DETAIL = ?\n" + "END");

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
                        codeItem = entry.getValue().toString();
                    }else if (entry.getKey().toString().equals("LOT")){
                        pstm.setString(8, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("QTY")){
                        pstm.setInt(9, Integer.parseInt(entry.getValue().toString()));
                        String sql = "SELECT WEIGHT_DECIMAL_DIGITS FROM MST_ITEM where WHERE CODE_ITEM = '"+codeItem+"'; ";
                        qty = Integer.parseInt(entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("MEMO1")){
                        pstm.setString(10, entry.getValue().toString());
                    }else if (entry.getKey().toString().equals("MEMO2")){
                        pstm.setString(11, entry.getValue().toString());
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
                String sql = "SELECT WEIGHT_DECIMAL_DIGITS FROM MST_ITEM where WHERE CODE_ITEM = '"+codeItem+"'; ";
                // 更新未组盘的数据
                pstmt1.setString(1, String.valueOf(qty));
                pstmt1.setString(2, stmt.executeQuery(sql).getString(1));
                pstmt1.setString(3, memo3);
                pstmt1.setString(4, memo4);
                pstmt1.addBatch();
                pstm.addBatch();
            }
            pstm.executeBatch();
            conn.commit();
            stmt.close();
            pstm.close();
            pstmt1.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * 转换小数点
     */
    public int returnInt(){
        return 1;
    }




}
