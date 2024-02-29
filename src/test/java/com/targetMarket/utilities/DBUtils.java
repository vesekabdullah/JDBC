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
            System.out.println("resultSet destroyed");
        }
        if (statement != null) {
            statement.close();
            System.out.println("statement destroyed");
        }
        if (connection != null) {
            connection.close();
            System.out.println("connection destroyed");
        }


    }

    public static List<Map<String, Object>> getQueryResultMap(String query) {
        // Execute the query
        executeQuery(query);

        // Create an empty list to store the result
        List<Map<String, Object>> result = new ArrayList<>();

        // Declare a ResultSetMetaData object
        ResultSetMetaData rsmd;

        try {
            // Get the metadata of the result set
            rsmd = resultSet.getMetaData();

            // Iterate through each row in the result set
            while (resultSet.next()) {
                // Create a map to store column name-value pairs for the current row
                Map<String, Object> colNameValueMap = new HashMap<>();

                // Iterate through each column in the result set
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    // Retrieve the column name and value for the current column
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }

                // Add the column name-value map to the result list
                result.add(colNameValueMap);
            }
        } catch (SQLException e) {
            // If there is an error, throw a runtime exception
            throw new RuntimeException(e);
        }

        // Return the result list
        return result;
    }



}
