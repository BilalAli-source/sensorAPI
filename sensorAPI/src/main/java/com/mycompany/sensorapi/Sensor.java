/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sensorapi;

/**
 *
 * @author bilalali
 */

import java.util.*;

public class Sensor {

    public String id;
    public String type;
    public String roomId;
    public double currentValue;

    // NEW: readings list
    public List<SensorReading> readings = new ArrayList<>();

    public Sensor() {}

    public Sensor(String id, String type, String roomId) {
        this.id = id;
        this.type = type;
        this.roomId = roomId;
        this.currentValue = 0.0;
    }
}