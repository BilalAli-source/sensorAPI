/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.sensorapi;

/**
 *
 * @author bilalali
 */
public class SensorUnavailableException extends RuntimeException {

    /**
     * Creates a new instance of <code>SensorUnavailableException</code> without
     * detail message.
     */
    public SensorUnavailableException() {
    }

    /**
     * Constructs an instance of <code>SensorUnavailableException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public SensorUnavailableException(String msg) {
        super(msg);
    }
}
