package SqlAnywhereDB;

import com.sun.deploy.config.VerboseDefaultConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


public class getConnSybase {

    /**
     * 连接数据库
     */
    public static void main(String[] args) {

        System.out.print(getConnSybase());
    }
    public static Connection getConnSybase() {
        try {
            Connection conn;
//            InputStream path =Thread.currentThread().getContextClassLoader().getResourceAsStream("analysis.properties");
//            VerboseDefaultConfig config = new VerboseDefaultConfig();
//            config.clear();
//            config.load(path);
            String url = "jdbc:sybase:Tds:192.0.1.136:2638/WMS_BBB";
            String username = "R200";
            String password = "R200";
            String drier = "com.sybase.jdbc4.jdbc.SybDriver";
            Class.forName(drier).newInstance();
            conn = DriverManager.getConnection(url,username,password);

            String SQL = "BEGIN\n"
                    + " SELECT * FROM CTL_TRANS "
                    + "     ORDER BY NUM_UNIT\n"
                    + "END";

            Statement stmt = conn.createStatement();
            if( stmt.execute(SQL) )
            {
                int i = 0;
                ResultSet rs = stmt.getResultSet();
                while( rs != null )
                {
                    System.out.println( "\n---Result set---\n" );
                    while (rs.next())
                    {
                        System.out.println(rs.getString(1)
                                + ", " + rs.getString(2)
                                + ", " + rs.getString(3) );
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
            return null;
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return null;
    }
}
