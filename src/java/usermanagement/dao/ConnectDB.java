/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ConnectDB {
    private String hostName;
    private String instance;
    private String port;
    private String dbName;
    private String userName;
    private String password;

    public ConnectDB() {
        this.hostName = "localhost";
        this.instance = "DIEUVI";
        this.port = "1433";
        this.dbName = "demo";
        this.userName = "sa";
        this.password = "sa123456";
    }
    
  private String urlString(){
      return String.format("jdbc:sqlserver://%s%s:%s;DatabaseName=%s;UserName=%s;Password=%s;",
              this.hostName, (this.instance.length() > 0?"\\" + this.instance : ""), this.port, this.dbName, this.userName, this.password);
  }  
  public Connection getConnection() throws ClassNotFoundException, SQLException{
      Connection connect = null;
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      connect = DriverManager.getConnection(urlString());
      return connect;
  }
}
