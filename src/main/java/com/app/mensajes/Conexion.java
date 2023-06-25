package com.app.mensajes;
import  java.sql.*;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost/mensajes?serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "1234";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,user, pass);
    };
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close(PreparedStatement ps) throws SQLException{
        ps.close();
    }
    
     public static void close(Connection con) throws SQLException{
        con.close();
    }
}
