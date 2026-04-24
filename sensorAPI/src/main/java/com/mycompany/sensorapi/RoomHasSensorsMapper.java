/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sensorapi;

/**
 *
 * @author bilalali
 */


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RoomHasSensorsMapper implements ExceptionMapper<RoomHasSensorsException> {

    @Override
    public Response toResponse(RoomHasSensorsException ex) {
        return Response.status(409)
                .entity("{\"error\":\"" + ex.getMessage() + "\"}")
                .build();
    }
}