package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class AlarmSystem {
    private AlarmSystemState systemState;

    public AlarmSystem() {
        this.systemState = new AlarmSystemStateOff(this);
    }

    public AlarmSystemStateEnum getSystemState(){
        return systemState.getState();
    }

    public void turnOn(){
        this.systemState.turnOn();
    }

    public void onSensor(SensorEvent event){
        this.systemState.onEvent(event);
    }

    public void setSystemState(AlarmSystemState systemState) {
        this.systemState = systemState;
    }
}
