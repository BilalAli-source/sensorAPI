/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sensorapi;

/**
 *
 * @author bilalali
 */


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

public class SensorReadingResource {

    private Sensor sensor;

    public SensorReadingResource(Sensor sensor) {
        this.sensor = sensor;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SensorReading> getReadings() {
        return sensor.readings;
    }

    @POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public SensorReading addReading(SensorReading reading) {

    if (reading == null) {
        throw new BadRequestException("Invalid reading");
    }

    // 🔥 SIMULATE unavailable sensor
    if (sensor.id.equalsIgnoreCase("S999")) {
        throw new SensorUnavailableException("Sensor is currently unavailable");
    }

    sensor.readings.add(reading);

    sensor.currentValue = reading.value;

    return reading;
}}