package com.fengwenyi.lib.java;

import java.sql.*;

/**
 * Wenyi Feng(xfsy2014@gmail.com)
 * 2017-09-26 17:31
 */
public class DBUtil {

    /**
     * 数据库ip
     */
    private String ip;
    /**
     * 数据库端口
     */
    private int port;
    /**
     * 数据库名字
     */
    private String dbName;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;



    public DBUtil(String ip, int port, String dbName, String username, String password) {
        this.ip = ip;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public DBUtil(String dbName, String username, String password) {
        this.ip = "localhost";
        this.port = 3306;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    /**
     * 驱动
     */
    private static String driver = "com.mysql.jdbc.Driver";

    /**
     * 连接数据库
     * @return Connection
     * @throws ClassNotFoundException 驱动异常
     * @throws SQLException SQL异常
     */
    public Connection dbConn()
            throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + dbName
                + "?useUnicode=true&amp;characterEncoding=UTF-8";
        Class.forName(driver);
        return DriverManager.getConnection(url, username, password);
    }

    // 增删查改
    public int execute(String sql) throws SQLException, ClassNotFoundException {
        // 连接数据库
        Connection conn = dbConn();
        // 操作
        PreparedStatement ps = conn.prepareStatement(sql);
        int rowNum = ps.executeUpdate();
        // 关闭数据
        dbClose();
        return rowNum;
    }

    public ResultSet query(Connection conn, String sql) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        return rs;
    }

    /**
     * 设置驱动
     * @param driver
     */
    public void setDriver(String driver) {
        DBUtil.driver = driver;
    }

    /**
     * 关闭数据库连接
     * @throws SQLException
     */
    public void dbClose() throws SQLException, ClassNotFoundException {
        Connection conn = dbConn();
        if (!conn.isClosed()) conn.close();
    }
}
