/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.cst8288Lab2.dao;

import java.sql.Connection;

/**
 *
 * @author renxihai
 */
public abstract class GenericDAO<E> {

 private Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    abstract public int insert(E e);

    abstract public int update(E e);


}
