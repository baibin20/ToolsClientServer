import java.io.*;
import java.sql.*;

public class results {
    public static void main(String[] args) throws Exception
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(
                    "jdbc:sqlanywhere://localhost:2638/WMS?user=R200＆password=R200" );
            String SQL = "BEGIN\n"
                    + " SELECT * FROM Departments "
                    + "     ORDER BY DepartmentID;\n"
                    + " SELECT EmployeeID, Surname, GivenName "
                    + "     FROM Employees e "
                    + "     JOIN Departments d "
                    + "     ON DepartmentHeadID = EmployeeID "
                    + "     ORDER BY d.DepartmentID\n"
                    + "END";
            Statement stmt = conn.createStatement();
            if( stmt.execute(SQL) )
            {
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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if( conn != null) conn.close();
    }

}
