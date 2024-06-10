/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/06/14
 * Description: Assignment 2 - Library Management System
 */
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

/**
 * A utility class to handle database operations for Event objects. This class
 * provides methods to create, retrieve, update, and delete Event objects in the
 * database. It uses LMSLogger for logging and DBConnection for managing
 * database connections.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class DBOperations {

    /**
     * Creates a new event in the database. Logs the operation and returns the
     * generated event ID.
     *
     * @param event the event to be created
     * @return the generated event ID, or -1 if the operation fails
     */
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

    /**
     * Retrieves an event from the database by its ID. Logs the operation and
     * returns the Event object.
     *
     * @param event_id the ID of the event to be retrieved
     * @return the retrieved Event object, or null if not found
     */
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

    /**
     * Updates an existing event in the database. Logs the operation and updates
     * the event details.
     *
     * @param event the event to be updated
     * @throws IllegalArgumentException if the event is null
     */
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

    /**
     * Deletes an event from the database by its ID. Logs the operation and
     * returns true if the event was deleted.
     *
     * @param event_id the ID of the event to be deleted
     * @return true if the event was successfully deleted, false otherwise
     */
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
            result = affectRow > 0;
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
