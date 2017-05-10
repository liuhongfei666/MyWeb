package com.myweb.utils;


import java.sql.*;

/**
 * Created by Liu on 2017-05-09.
 */
public class DBUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:/test?useUnicode=true&characterEncoding=utf-8";
    private static String userName = "root";
    private static String password = "root";
    private static Connection connection = null;

    /*初始化驱动*/
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("can't found Driver..");
            e.printStackTrace();
        }
    }

    /*获取连接*/
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("get connection fail..");
            e.printStackTrace();
        }
        return connection;
    }

    /*处理结果*/
    public static void process(Connection conn, String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (conn != null && sql.trim() != "") {
            try {
                ps = conn.prepareStatement(sql);
                if (ps.execute()) {
                    rs = ps.getResultSet();
                } else {
                    int i = ps.getUpdateCount();
                }
            } catch (SQLException e) {
                System.out.println("error..");
                e.printStackTrace();
            } finally {

            }
        }
        System.out.println("argument error..");
    }

    public static void printResult(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            StringBuffer sb = new StringBuffer();
            while (rs.next()) {
                for (int i = 0; i < columns; i++) {
                    sb.append(metaData.getColumnName(i) + " =");
                    sb.append(rs.getString(i) + "/n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*关闭连接*/
    public static void close(ResultSet rs, Statement statement, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
