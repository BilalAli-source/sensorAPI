package com.mycompany.sensorapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/rooms")
public class RoomResource {

    private static Map<String, Room> rooms = new HashMap<>();

    // 🔓 Allow other classes (like SensorResource) to access rooms
    public static Map<String, Room> getRoomsMap() {
        return rooms;
    }

    // ✅ GET all rooms
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Room> getRooms() {
        return rooms.values();
    }

    // ✅ POST create room
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Room createRoom(Room room) {

        if (room == null) {
            throw new BadRequestException("No JSON body received");
        }

        if (room.id == null || room.id.isEmpty()) {
            throw new BadRequestException("Room ID is required");
        }

        if (room.name == null || room.name.isEmpty()) {
            throw new BadRequestException("Room name is required");
        }

        rooms.put(room.id, room);
        return room;
    }

    // ✅ GET room by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoom(@PathParam("id") String id) {

        Room room = rooms.get(id);

        if (room == null) {
            throw new NotFoundException("Room not found");
        }

        return room;
    }

    // ✅ DELETE room
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteRoom(@PathParam("id") String id) {

        if (!rooms.containsKey(id)) {
            throw new NotFoundException("Room not found");
        }

        rooms.remove(id);

        return "{\"message\":\"Room deleted successfully\"}";
    }
}