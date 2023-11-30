package co.wedevx.digitalbank.automation.ui.utils;

import static co.wedevx.digitalbank.automation.ui.utils.ConfigReader.getPropertiesValue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
  private static Connection connection = null;
  private static Statement statement = null;
  private static ResultSet resultSet = null;

  //method to establish connection with the db
  public static void establishConnection() throws SQLException {


    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(
          getPropertiesValue("digitalbank.db.url"),
          getPropertiesValue("digitalbank.db.username"),
          getPropertiesValue("digitalbank.db.password"));


    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Unable to establish Connection");
       e.printStackTrace();
       throw new SQLException("Unable to establish DB connection");
    }
  }

  //a method that can dynamically send select statements and return a list of map of all columns
  public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery){
    List<Map<String, Object>> dbResultList = new ArrayList<>();
    try {
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sqlQuery);

      //getMetData() method return info about your info
      ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
      int columnCount = resultSetMetaData.getColumnCount();
      while (resultSet.next()){
        Map<String, Object> rowMap = new HashMap<>();

        for(int col = 1; col <= columnCount; col++){
          rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));
        }
        dbResultList.add(rowMap);

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return dbResultList;
  }

  //create a method that inserts into db and return the number of rows updated and zero when action is not taken

  //update query
  public static int runSQLUpdateQuery(String sqlQuery){
    int rowAffected = 0;
    try {
      statement = connection.createStatement();
      rowAffected = statement.executeUpdate(sqlQuery);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rowAffected;
  }

  //method to close connection
  public static void closeConnection(){
    try{
      if(resultSet != null){
        resultSet.close();
      }
      if(statement != null){
        statement.close();
      }
      if(connection != null){
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
