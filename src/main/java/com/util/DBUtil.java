package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://119.45.239.3:3306/student?characterEncoding=utf8&useSSL=false", "admin", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static PreparedStatement prepareStmt(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public static ResultSet executeQuery(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static void close(Connection conn, Statement stmt,
                             PreparedStatement preStatement, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (preStatement != null) {
            try {
                preStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preStatement = null;
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }
}

