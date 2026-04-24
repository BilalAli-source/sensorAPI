/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.sensorapi;

/**
 *
 * @author bilalali
 */
public class RoomNotFoundForSensorException extends RuntimeException {

    /**
     * Creates a new instance of <code>RoomNotFoundForSensorException</code>
     * without detail message.
     */
    public RoomNotFoundForSensorException() {
    }

    /**
     * Constructs an instance of <code>RoomNotFoundForSensorException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RoomNotFoundForSensorException(String msg) {
        super(msg);
    }
}
