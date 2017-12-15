package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorScenarioRunner implements EventHandler {
    @Override
    public void handle(SmartHome home, SensorEvent event) {
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            // событие от двери
            for (Room room : home.getRooms()) {
                for (Door door : room.getDoors()) {
                  //если эта дверь породила это событие
                    if (door.getId().equals(event.getObjectId()) && room.getName().equals("hall")) {
                        if (event.getType() == DOOR_OPEN) {
                                for (Room homeRoom : home.getRooms()) {
                                    for (Light light : homeRoom.getLights()) {
                                        light.setOn(true);
                                    }
                                    for (Door door1 : homeRoom.getDoors()) {
                                        door1.setOpen(true);
                                    }
                            }
                        }
                        else{
                            for (Room homeRoom : home.getRooms()) {
                                for (Light light : homeRoom.getLights()) {
                                    light.setOn(false);
                                }
                                for (Door door1 : homeRoom.getDoors()) {
                                    door1.setOpen(false);
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}
