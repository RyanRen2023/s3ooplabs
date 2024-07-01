/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.cst8288Lab2.dao;


/**
 *
 * @author renxihai
 * @param <E>
 * @param <ID>
 */
public interface OneIdCRUD<E, ID> {

    public E retrieve(ID id);

    public int delete(ID id);

}
