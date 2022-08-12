package service;

import connection.ConnectionDB;
import entity.Grades;
import entity.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GradesService extends ConnectionDB {
    Connection connection;

    {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Grades grades) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO grades (student_id,grade) VALUES (?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, grades.getId());
            preparedStatement.setInt(2, grades.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeGrade(Grades grades) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM grades WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, grades.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Grades grades) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE grades SET GRADE='8' WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, grades.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void search(Grades grades) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM grades WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, grades.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
