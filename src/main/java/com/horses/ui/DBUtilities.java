package com.horses.ui;
import com.horses.dbmanage.Config;

import java.sql.*;

public class DBUtilities {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public DBUtilities() throws SQLException {
        try {
            connection = DriverManager.getConnection(Config.connection_url, Config.DATABASE_USER_ID, Config.DATABASE_PASSWORD);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();
            CurrentUserData.executeSetUserId();
            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}