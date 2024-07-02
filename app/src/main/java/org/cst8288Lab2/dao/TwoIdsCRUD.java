/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Two IDs CRUD Interface
 */
package org.cst8288Lab2.dao;

/**
 * An interface that defines basic CRUD operations for entities identified by
 * two IDs.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @param <E> the type of entity managed by this DAO
 * @param <ID1> the type of the first ID used to identify the entity
 * @param <ID2> the type of the second ID used to identify the entity
 *
 * @author Xihai Ren
 */
public interface TwoIdsCRUD<E, ID1, ID2> {

    /**
     * Retrieves an entity by its two IDs.
     *
     * @param id1 the first ID of the entity to retrieve
     * @param id2 the second ID of the entity to retrieve
     * @return the entity corresponding to the specified IDs
     */
    public E retrieve(ID1 id1, ID2 id2);

    /**
     * Deletes an entity by its two IDs.
     *
     * @param id1 the first ID of the entity to delete
     * @param id2 the second ID of the entity to delete
     * @return the number of rows affected by the delete operation
     */
    public int delete(ID1 id1, ID2 id2);
}
