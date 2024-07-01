package org.cst8288Lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.cst8288Lab2.dto.StudentCourseDTO;
import org.cst8288Lab2.dto.Term;

public class StudentCourseDAO extends GenericDAO<StudentCourseDTO> implements TwoIdsCRUD<StudentCourseDTO, Integer, String> {

    public StudentCourseDAO(Connection connection) {
        super(connection);
    }

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

    @Override
    public int insert(StudentCourseDTO studentCourse) {
        String sql = "INSERT INTO studentcourse (studentId, courseId, term, year) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        int studentId = -1;
        try {
            statement = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, studentCourse.getStudentId());
            statement.setString(2, studentCourse.getCourseId());
            statement.setInt(3, studentCourse.getTerm());
            statement.setInt(4, studentCourse.getYear());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                studentId = rs.getInt(1);
            }

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

        return studentId;
    }

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

}
