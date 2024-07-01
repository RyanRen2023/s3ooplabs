/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.cst8288Lab2.dao;


/**
 *
 * @author renxihai
 * @param <E>
 * @param <ID1>
 * @param <ID2>
 */
public interface TwoIdsCRUD<E,ID1,ID2>{

    
    abstract public E retrieve(ID1 id1, ID2 id2);
    abstract public int delete(ID1 id1, ID2 id2);
    
}
