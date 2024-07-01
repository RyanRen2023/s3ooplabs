package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.cst8288Lab2.dto.CourseDTO;

public class CourseDAO extends GenericDAO<CourseDTO> implements OneIdCRUD<CourseDTO, String> {

    public CourseDAO(Connection connection) {
        super(connection);
    }

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
     *
     * @param e
     * @return
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
