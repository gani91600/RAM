package com.example.student.dao;

import com.example.student.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/studentdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String INSERT_STUDENTS_SQL = "INSERT INTO students" +
            " (name, email, course) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";

    public StudentDao() {}

    protected Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    public void addStudent(Student student) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                students.add(new Student(id, name, email, course));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
