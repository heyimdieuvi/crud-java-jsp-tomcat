/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import usermanagemen.model.User;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
    private static final String INSERT_USERS_SQL = "insert into users" + "(name, email, country) values" + "(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id, name, email, country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email =?, country = ? where id = ?";

    public UserDAO() {
    }
    
    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = new ConnectDB().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
             preparedStatement.setString(3, user.getCountry());
             System.out.println(preparedStatement);
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    //check xem id co ton tai khong?
    public User selectUser(int id) throws ClassNotFoundException{
        User user = null;
        try (Connection connect = new ConnectDB().getConnection();
                PreparedStatement statement = connect.prepareStatement(SELECT_USER_BY_ID)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return user;
    }
    
    public void printSQLException(SQLException ex){
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQL State: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }     
        }
    }

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
}
