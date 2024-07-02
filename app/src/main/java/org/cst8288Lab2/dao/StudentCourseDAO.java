/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Access Object for StudentCourse
 */
package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.Term;

/**
 * A Data Access Object (DAO) class to manage StudentCourse data in the
 * database. This class provides methods to retrieve, insert, update, and delete
 * StudentCourse records.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @autor Xihai Ren
 */
public class StudentCourseDAO extends GenericDAO<StudentCourseDTO> implements TwoIdsCRUD<StudentCourseDTO, Integer, String> {

    /**
     * Constructs a StudentCourseDAO with the specified database connection.
     *
     * @param connection the database connection to be used by this DAO
     */
    public StudentCourseDAO(Connection connection) {
        super(connection);
    }

    /**
     * Retrieves a StudentCourseDTO object from the database using the specified
     * student ID and course ID.
     *
     * @param studentId the student ID
     * @param courseId the course ID
     * @return the StudentCourseDTO object corresponding to the specified
     * student ID and course ID, or null if no matching record is found
     */
    @Override
    public StudentCourseDTO retrieve(Integer studentId, String courseId) {
        StudentCourseDTO studentCourse = null;
        String sql = "SELECT * FROM studentcourse WHERE studentId = ? and courseId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, studentId);
            statement.setString(2, courseId);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                studentCourse = new StudentCourseDTO();
                studentCourse.setStudentId(resultSet.getInt("studentId"));
                studentCourse.setCourseId(resultSet.getString("courseId"));
                studentCourse.setTerm(Term.getTerm(resultSet.getInt("term")));
                studentCourse.setYear(resultSet.getInt("year"));
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

        return studentCourse;
    }

    /**
     * Inserts a new StudentCourseDTO object into the database.
     *
     * @param studentCourse the StudentCourseDTO object to insert
     * @return the generated student ID if the insert operation was successful,
     * or -1 if an error occurred
     */
    @Override
    public int insert(StudentCourseDTO studentCourse) {
        String sql = "INSERT INTO studentcourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, studentCourse.getStudentId());
            statement.setString(2, studentCourse.getCourseId());
            statement.setInt(3, studentCourse.getTerm());
            statement.setInt(4, studentCourse.getYear());
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
     * Updates an existing StudentCourseDTO object in the database.
     *
     * @param studentCourse the StudentCourseDTO object to update
     * @return the number of rows affected by the update operation, or -1 if an
     * error occurred
     */
    @Override
    public int update(StudentCourseDTO studentCourse) {
        String sql = "UPDATE studentcourse SET term = ?, year = ? WHERE studentId = ? and courseId=?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, studentCourse.getTerm());
            statement.setInt(2, studentCourse.getYear());
            statement.setInt(3, studentCourse.getStudentId());
            statement.setString(4, studentCourse.getCourseId());
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
     * Deletes a StudentCourseDTO object from the database using the specified
     * student ID and course ID.
     *
     * @param studentId the student ID
     * @param courseId the course ID
     * @return the number of rows affected by the delete operation, or -1 if an
     * error occurred
     */
    @Override
    public int delete(Integer studentId, String courseId) {
        String sql = "DELETE FROM studentcourse WHERE studentId = ? and courseId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, studentId);
            statement.setString(2, courseId);
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
    
    public int deleteByStudentId(Integer studentId) {
        String sql = "DELETE FROM studentcourse WHERE studentId = ? and courseId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setInt(1, studentId);
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
    
    public int deleteByCourseId(String courseId) {
        String sql = "DELETE FROM studentcourse WHERE courseId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setString(1, courseId);
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
