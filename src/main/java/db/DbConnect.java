package db;

import java.sql.*;

public class DbConnect {

    String url = "jdbc:mysql://localhost:3306/coffee";
    String userName = "root";
    String password = "1234";

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DBConnect(): jdbc.Driver success");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("DBConnect(): "+e.getMessage());
        }
    }
    public Connection getConnection()
    {
        Connection conn=null;

        try {
            conn=DriverManager.getConnection(url, userName, password);
            System.out.println("getConnection(): success");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getConnection():sql failed: "+e.getMessage());
        }


        return conn;
    }

    //close 총 4개 오버로딩
    public void dbClose(ResultSet rs,Statement stmt,Connection conn)
    {

        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dbClose(Statement stmt,Connection conn)
    {

        try {

            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn)
    {

        try {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dbClose(PreparedStatement pstmt,Connection conn)
    {

        try {

            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws SQLException {
        DbConnect db = new DbConnect();
        db.getConnection();
    }
}