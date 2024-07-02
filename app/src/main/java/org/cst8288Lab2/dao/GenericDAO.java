/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Generic Data Access Object
 */
package org.cst8288Lab2.dao;

import java.sql.Connection;

/**
 * An abstract generic Data Access Object (DAO) class that provides basic
 * methods for database operations. This class should be extended by specific
 * DAO classes that manage different types of entities.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @param <E> the type of entity managed by this DAO
 *
 * @author Xihai Ren
 */
public abstract class GenericDAO<E> {

    private Connection connection;

    /**
     * Constructs a GenericDAO with the specified database connection.
     *
     * @param connection the database connection to be used by this DAO
     */
    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Returns the database connection used by this DAO.
     *
     * @return the database connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Sets the database connection to be used by this DAO.
     *
     * @param connection the database connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Inserts the specified entity into the database.
     *
     * @param e the entity to insert
     * @return the number of rows affected by the insert operation
     */
    public abstract int insert(E e);

    /**
     * Updates the specified entity in the database.
     *
     * @param e the entity to update
     * @return the number of rows affected by the update operation
     */
    public abstract int update(E e);
}
