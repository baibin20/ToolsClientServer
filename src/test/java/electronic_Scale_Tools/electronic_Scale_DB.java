package electronic_Scale_Tools;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.sql.*;
import java.util.Properties;

public class electronic_Scale_DB {
    private static final String DRIVER = "sybase.jdbc4.sqlanywhere.IDriver"; // jdbc4.0
    private static final String URL = "jdbc:sqlanywhere:uid=R200;pwd=R200;eng= demodb;database= WMS;links=tcpip(host=127.0.0.1)";

    public electronic_Scale_DB() {
    }

    public static void main(String[] args) {
        electronic_Scale_DB demo = new electronic_Scale_DB();
        try {
            demo.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() throws Exception {
        Connection con = this.getConnection(DRIVER, URL);
        PreparedStatement pstmt = con.prepareStatement("SELECT GETDATE() ");
        ResultSet rs = pstmt.executeQuery();
        this.processResult(rs);
        this.closeConnection(con, pstmt);
    }
    private void processResult(ResultSet rs) throws Exception {
        if (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colNum = rsmd.getColumnCount();
            for (int i = 1; i <= colNum; i++) {
                if (i == 1) {
                    System.out.print(rsmd.getColumnName(i));
                } else {
                    System.out.print("\t" + rsmd.getColumnName(i));
                }
            }
            System.out.print("\n");
            System.out.println("-----------------------");
            do {
                for (int i = 1; i <= colNum; i++) {
                    if (i == 1) {
                        System.out.print(rs.getString(i));
                    } else {
                        System.out.print("\t"
                                + (rs.getString(i) == null ? "null" : rs
                                .getString(i).trim()));
                    }
                }
                System.out.print("\n");
            } while (rs.next());
        } else {
            System.out.println("query not result.");
        }
    }

    private Connection getConnection(String driver, String url)
            throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }

    private void closeConnection(Connection con, Statement stmt)
            throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }
}

