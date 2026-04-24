# sensorAPI

## Overview of this API
This API controls how you create, read, and delete Rooms, Sensors, and sensor readings.

- A room represents a real-world location.  
- A sensor belongs to one room.  
- A sensor stores its readings.  

You can validate data before saving it, handle errors gracefully, and log requests and responses while managing Rooms, Sensors, and their readings.

---

## How to Start Using It

1. Open this project in Apache NetBeans  
2. Clean and Build the project  
3. Run the project  
4. The server will be available at: http://localhost:8080  

---

## Example curl Commands

### Create Room
curl -X POST http://localhost:8080/rooms \
-H "Content-Type: application/json" \
-d '{"id":"R1","name":"Room 1"}'

### Get All Rooms
curl http://localhost:8080/rooms

### Create Sensor
curl -X POST http://localhost:8080/sensors \
-H "Content-Type: application/json" \
-d '{"id":"S1","type":"CO2","roomId":"R1"}'

### Get Sensors
curl http://localhost:8080/sensors

### Add Reading to Sensor
curl -X POST http://localhost:8080/sensors/S1/readings \
-H "Content-Type: application/json" \
-d '{"value":25.5}'

---

## Answers

### 1. Why do we use REST architecture?
We use REST because it allows us to communicate over HTTP using standard methods like GET, POST, and DELETE. It keeps the API simple and easy to use from different clients.

---

### 2. Why do we use query parameters?
We use query parameters to filter data (for example, getting all CO2 sensors) without modifying the endpoint structure.

---

### 3. Why do we use sub-resources?
We use sub-resources to represent relationships between entities. For example, readings belong to a specific sensor, so they are accessed via `/sensors/{id}/readings`.

---

### 4. Why do we create custom exceptions?
Custom exceptions allow us to handle different error scenarios clearly. For example:
- 409 Conflict when a room has active sensors  
- 422 Unprocessable Entity when a sensor references a non-existent room  
- 403 Forbidden when a sensor is unavailable  

---

### 5. Why do we use logging?
Logging helps track every request and response, which is useful for debugging and monitoring API behaviour.
