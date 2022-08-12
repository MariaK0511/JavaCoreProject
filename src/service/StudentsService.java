package service;

import connection.ConnectionDB;
import entity.Grades;
import entity.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsService extends ConnectionDB {
    Connection connection;

    {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Students> getAll() throws SQLException {
        List<Students> studentsList = new ArrayList<>();
        String sql = "SELECT * FROM mystudents";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Students students = new Students();
                students.setId(resultSet.getLong("student_id"));
                students.setName(resultSet.getString("name"));
                studentsList.add(students);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public void add(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO mystudents (student_id, name) VALUES (?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
            preparedStatement.setString(2, students.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeByName(Students students) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM mystudents  WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE mystudents SET NAME='John S' WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void search(Students students) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM mystudents WHERE student_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, students.getId());
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

