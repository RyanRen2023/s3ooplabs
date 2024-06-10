package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventFactory;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {

    public static int createEvent(Event event) {
        LMSLogger.getLMSLogger().info(DBOperations.class.getSimpleName() + " create event.");

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        String sql = "insert into events(event_name,event_description,event_activities,admission_fees)values(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDescription());
            preparedStatement.setString(3, event.getEventActivities());
            preparedStatement.setDouble(4, event.getAdmissionFees());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int eventId = rs.getInt(1);
                System.out.println("Generated Key is :" + eventId);
                return eventId;
            }

        } catch (SQLException ex) {
            LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + ex.getMessage());

        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + e.getMessage());

            }
        }
        return -1;
    }

    public static Event retrieveEvent(int event_id) {
        LMSLogger.getLMSLogger().info(DBOperations.class.getSimpleName() + " retrieve event by id=" + event_id);

        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        String sql = "select event_id,event_name,event_description,event_activities,admission_fees from events where event_id=?";
        Event event = null;
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, event_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int eventId = rs.getInt(1);
                String eventName = rs.getString(2);
                String description = rs.getString(3);
                String activity = rs.getString(4);
                double adminFee = rs.getDouble(5);
                event = EventFactory.createEvent(EventType.valueOf(activity));
                event.setEventId(eventId);
                event.setEventName(eventName);
                event.setEventDescription(description);
                event.setEventActivities(activity);
                event.setAdmissionFees(adminFee);

            }

        } catch (SQLException ex) {
            LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + ex.getMessage());

        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + e.getMessage());

            }
        }
        return event;

    }

    public static void updateEvent(Event event) {

        LMSLogger.getLMSLogger().info(DBOperations.class.getSimpleName() + " update event.");

        if (event == null) {
            throw new IllegalArgumentException("Parameter event should not be null");
        }
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        String sql = "update events set event_name=?,event_description=?,event_activities=?,admission_fees=? where event_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setString(2, event.getEventDescription());
            preparedStatement.setString(3, event.getEventActivities());
            preparedStatement.setDouble(4, event.getAdmissionFees());
            preparedStatement.setInt(5, event.getEventId());
            preparedStatement.execute();

        } catch (SQLException ex) {
            LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + ex.getMessage());

        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + e.getMessage());

            }
        }
    }

    public static boolean deleteEvent(int event_id) {
        LMSLogger.getLMSLogger().info(DBOperations.class.getSimpleName() + " delete event by id=" + event_id);
        PreparedStatement preparedStatement = null;
        Connection connection = DBConnection.getConnection();
        boolean result = false;
        String sql = "delete from events where event_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, event_id);
            int affectRow = preparedStatement.executeUpdate();
            result = affectRow > 0 ? true : false;
        } catch (SQLException ex) {
            LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + ex.getMessage());

        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                LMSLogger.getLMSLogger().error(DBOperations.class.getSimpleName() + " " + e.getMessage());

            }
        }
        return result;
    }
}
