package com.targetMarket.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {


    private static final String DB_URL = ConfigurationReader.getProperty("db_URL");
    private static final String DB_USER =  ConfigurationReader.getProperty("db_username");
    private static final String DB_PASSWORD = ConfigurationReader.getProperty("db_password");

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;


    /**
     * Creates a connection to the database using the properties from the config file.
     *
     * @throws RuntimeException If there is an error connecting to the database.
     */
    public static void createConnection() {
        try {
            // Create the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("DB connection is created!!");
        } catch (SQLException e) {
            // If there is an error, throw a runtime exception
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes a SQL query and stores the result set in a class variable.
     *
     * @param query The SQL query to execute.
     * @throws RuntimeException If there is an error executing the query.
     */
    public static ResultSet executeQuery(String query) {
        try {
            // Create the statement and execute the query
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            // If there is an error, throw a runtime exception
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    /**
     * Closes the statement, result set, and connection.
     *
     * @throws SQLException If there is an error closing the database objects.
     */
    public static void destroy() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }


}
