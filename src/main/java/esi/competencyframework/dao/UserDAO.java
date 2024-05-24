package esi.competencyframework.dao;

import esi.competencyframework.model.User;
import lombok.SneakyThrows;

import java.sql.*;

public class UserDAO {
  private Connection getConnection() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/competency_framework";
    String username = "root";
    String password = "";
    return DriverManager.getConnection(url, username, password);
  }

  @SneakyThrows
  public Boolean checkIfEmailExists(String email) {
    Connection connection = getConnection();
    final String query = "SELECT COUNT(*) FROM Users WHERE email = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, email);
    ResultSet resultSet = statement.executeQuery();
    resultSet.next();
    int count = resultSet.getInt(1);
    return count > 0;
  }

  @SneakyThrows
  public void addUser(User user) {
    Connection connection = getConnection();
    final String query = "INSERT INTO Users(email, password, first_name, last_name) VALUES(?, ?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, user.getEmail());
    statement.setString(2, user.getPassword());
    statement.setString(3, user.getFirstName());
    statement.setString(4, user.getLastName());
    statement.execute();
  }


}
