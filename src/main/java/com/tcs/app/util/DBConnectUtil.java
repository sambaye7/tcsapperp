package com.tcs.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBConnectUtil {
    private static final Logger LOGGER = Logger.getLogger(DBConnectUtil.class.getName());

    public static final String DB_URL = "jdbc:mysql://localhost/devquaddb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "devquad";

    // Prevent instantiation
    private DBConnectUtil() {}

    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQLException: ", e);
        } catch (ClassNotFoundException c) {
            LOGGER.log(Level.SEVERE, "ClassNotFoundException: ", c);
        }
        return conn;
    }
}