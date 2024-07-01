package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cst8288Lab2.dto.StudentDTO;

/**
 * DAO class for performing CRUD operations on the student table.
 */
public class StudentDAO extends GenericDAO<StudentDTO> implements OneIdCRUD<StudentDTO, Integer> {

    public StudentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public StudentDTO retrieve(Integer id) {
        StudentDTO student = null;
        String sql = "SELECT * FROM student WHERE studentId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                student = new StudentDTO();
                student.setStudentId(resultSet.getInt("studentId"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return student;
    }

    @Override
    public int insert(StudentDTO student) {
        String sql = "INSERT INTO student (studentId, firstName, lastName) VALUES (?,?, ?)";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int update(StudentDTO student) {
        String sql = "UPDATE student SET firstName = ?, lastName = ? WHERE studentId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setInt(3, student.getStudentId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM student WHERE studentId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
