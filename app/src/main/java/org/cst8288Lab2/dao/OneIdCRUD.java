/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - One ID CRUD Interface
 */
package org.cst8288Lab2.dao;

/**
 * An interface that defines basic CRUD operations for entities identified by a
 * single ID.
 *
 * @version 1.0.0
 * @since Oracle 17.0.11
 *
 * @param <E> the type of entity managed by this DAO
 * @param <ID> the type of ID used to identify the entity
 *
 * @author Xihai Ren
 */
public interface OneIdCRUD<E, ID> {

    /**
     * Retrieves an entity by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the entity corresponding to the specified ID
     */
    public E retrieve(ID id);

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     * @return the number of rows affected by the delete operation
     */
    public int delete(ID id);
}
