/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Access Object for Student
 */

package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cst8288Lab2.dto.StudentDTO;

/**
 * DAO class for performing CRUD operations on the student table.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class StudentDAO extends GenericDAO<StudentDTO> implements OneIdCRUD<StudentDTO, Integer> {

    /**
     * Constructs a StudentDAO with the specified database connection.
     *
     * @param connection the database connection to be used by this DAO
     */
    public StudentDAO(Connection connection) {
        super(connection);
    }

    /**
     * Retrieves a StudentDTO object from the database using the specified student ID.
     *
     * @param id the student ID
     * @return the StudentDTO object corresponding to the specified student ID,
     *         or null if no matching record is found
     */
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

    /**
     * Inserts a new StudentDTO object into the database.
     *
     * @param student the StudentDTO object to insert
     * @return the number of rows affected by the insert operation,
     *         or -1 if an error occurred
     */
    @Override
    public int insert(StudentDTO student) {
        String sql = "INSERT INTO student (studentId, firstName, lastName) VALUES (?,?,?)";
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

    /**
     * Updates an existing StudentDTO object in the database.
     *
     * @param student the StudentDTO object to update
     * @return the number of rows affected by the update operation,
     *         or -1 if an error occurred
     */
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

    /**
     * Deletes a StudentDTO object from the database using the specified student ID.
     *
     * @param id the student ID
     * @return the number of rows affected by the delete operation,
     *         or -1 if an error occurred
     */
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