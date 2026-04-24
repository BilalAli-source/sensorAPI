package com.mycompany.sensorapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/sensors")
public class SensorResource {

    private static Map<String, Sensor> sensors = new HashMap<>();

    // ✅ POST create sensor
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sensor createSensor(Sensor sensor) {

        if (sensor == null) {
            throw new BadRequestException("No JSON body received");
        }

        if (sensor.id == null || sensor.id.isEmpty()) {
            throw new BadRequestException("Sensor ID required");
        }

        if (sensor.roomId == null || sensor.roomId.isEmpty()) {
            throw new BadRequestException("Room ID required");
        }

        // 🔥 Check room exists
    if (!RoomResource.getRoomsMap().containsKey(sensor.roomId)) {
    throw new RoomNotFoundForSensorException("Room does not exist");
}

        sensors.put(sensor.id, sensor);
        return sensor;
    }

    // ✅ GET sensors (with filtering)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Sensor> getSensors(@QueryParam("type") String type) {

        if (type == null) {
            return sensors.values();
        }

        List<Sensor> filtered = new ArrayList<>();

        for (Sensor s : sensors.values()) {
            if (s.type.equalsIgnoreCase(type)) {
                filtered.add(s);
            }
        }

        return filtered;
    }

    // ✅ Sub-resource for readings
    @Path("/{id}/readings")
    public SensorReadingResource getReadingResource(@PathParam("id") String id) {

        Sensor sensor = sensors.get(id);

        if (sensor == null) {
            throw new NotFoundException("Sensor not found");
        }

        return new SensorReadingResource(sensor);
    }
}