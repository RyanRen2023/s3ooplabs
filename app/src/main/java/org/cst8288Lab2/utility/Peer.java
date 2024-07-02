/*
 * Student Name: Xihai Ren
 * Student No: 041127486
 * Professor: Islam Gomaa
 * Due Date: 2024/07/07
 * Description: Lab 2 - Generic Peer Class
 */
package org.cst8288Lab2.utility;

/**
 * A generic class to hold a pair of objects.
 *
 * @version 1.0.0
 * @param <K>
 * @param <V>
 * @since Oracle 17.0.11
 *
 * @author Xihai Ren
 */
public class Peer<K, V> {

    private K k;
    private V v;

    /**
     * Constructs a Peer object with the specified key and value.
     *
     * @param k the key
     * @param v the value
     */
    public Peer(K k, V v) {
        this.k = k;
        this.v = v;
    }

    /**
     * Returns the key.
     *
     * @return the key
     */
    public K getK() {
        return k;
    }

    /**
     * Sets the key.
     *
     * @param k the key to set
     */
    public void setK(K k) {
        this.k = k;
    }

    /**
     * Returns the value.
     *
     * @return the value
     */
    public V getV() {
        return v;
    }

    /**
     * Sets the value.
     *
     * @param v the value to set
     */
    public void setV(V v) {
        this.v = v;
    }
}
