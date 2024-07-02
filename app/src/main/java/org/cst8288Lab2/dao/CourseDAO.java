/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Data Access Object for Course
 */

package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cst8288Lab2.dto.CourseDTO;

/**
 * A Data Access Object (DAO) class to manage Course data in the database.
 * This class provides methods to retrieve, insert, update, and delete
 * Course records.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 * 
 * @author Xihai Ren
 */
public class CourseDAO extends GenericDAO<CourseDTO> implements OneIdCRUD<CourseDTO, String> {

    /**
     * Constructs a CourseDAO with the specified database connection.
     *
     * @param connection the database connection to be used by this DAO
     */
    public CourseDAO(Connection connection) {
        super(connection);
    }

    /**
     * Retrieves a CourseDTO object from the database using the specified course ID.
     *
     * @param id the course ID
     * @return the CourseDTO object corresponding to the specified course ID,
     *         or null if no matching course is found
     */
    @Override
    public CourseDTO retrieve(String id) {
        CourseDTO course = null;
        String sql = "SELECT * FROM course WHERE courseId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setString(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                course = new CourseDTO();
                course.setCourseId(resultSet.getString("courseId"));
                course.setCourseName(resultSet.getString("courseName"));
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

        return course;
    }

    /**
     * Inserts a new CourseDTO object into the database.
     *
     * @param e the CourseDTO object to insert
     * @return the number of rows affected, or -1 if an error occurred
     */
    @Override
    public int insert(CourseDTO e) {
        String sql = "INSERT INTO course (courseId, courseName) VALUES (?, ?)";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setString(1, e.getCourseId());
            statement.setString(2, e.getCourseName());
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return result;
    }

    /**
     * Updates an existing CourseDTO object in the database.
     *
     * @param course the CourseDTO object to update
     * @return the number of rows affected, or -1 if an error occurred
     */
    @Override
    public int update(CourseDTO course) {
        String sql = "UPDATE course SET courseName = ? WHERE courseId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setString(1, course.getCourseName());
            statement.setString(2, course.getCourseId());
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
     * Deletes a CourseDTO object from the database using the specified course ID.
     *
     * @param id the course ID
     * @return the number of rows affected, or -1 if an error occurred
     */
    @Override
    public int delete(String id) {
        String sql = "DELETE FROM course WHERE courseId = ?";
        PreparedStatement statement = null;
        int result = -1;
        try {
            statement = this.getConnection().prepareStatement(sql);
            statement.setString(1, id);
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