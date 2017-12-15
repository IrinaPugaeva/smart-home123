package ru.sbt.mipt.oop;

public class AlarmSystemStateOn implements AlarmSystemState{

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }
    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ON;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff(){
        alarmSystem.setSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystem.setSystemState(new AlarmSystemStateWaitForPassword(alarmSystem));
    }

    @Override
    public void enterPassword(String password) {

    }
}
