package ma.ac.esi.competencyframework.model;

import java.sql.*;
import java.util.ArrayList;


public class CompetencyDAO {
  private Connection getConnection() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/competency_framework";
    String username = "root";
    String password = "";
    return DriverManager.getConnection(url, username, password);
  }

  public boolean addCompetency(Competency competency) {
    final String sql = "INSERT INTO Competencies (name, description, domain, level) VALUES ( ?, ?, ?, ?)";
    try (Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, competency.getName());
      ps.setString(2, competency.getDescription());
      ps.setString(3, competency.getDomain());
      ps.setString(4, competency.getLevel());
      return ps.executeUpdate() > 0;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }

  public Competency getCompetency(int id) {
    Competency competency = null;
    final String sql = "SELECT * FROM Competencies WHERE id = ?";
    try (Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      rs.next();
      competency = new Competency(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getString("domain"), rs.getString("level"));
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return competency;
  }

  public ArrayList<Competency> getAllCompetencies() {
    ArrayList<Competency> competenciesList = new ArrayList<>();
    final String sql = "SELECT * FROM Competencies";
    try (Connection connection = getConnection()) {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        Competency competency = new Competency(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getString("domain"), rs.getString("level"));
        competenciesList.add(competency);
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return competenciesList;
  }

  public boolean removeCompetency(int id) {
    final String sql = "DELETE FROM Competencies WHERE id = ?";
    try (Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean editCompetency(Competency competency) {
    final String sql = "UPDATE Competencies SET name = ?, description = ?, domain = ?, level = ? WHERE id = ?";
    try (Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, competency.getName());
      ps.setString(2, competency.getDescription());
      ps.setString(3, competency.getDomain());
      ps.setString(4, competency.getLevel());
      ps.setInt(5, competency.getId());
      return ps.executeUpdate() > 0;
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }
}
