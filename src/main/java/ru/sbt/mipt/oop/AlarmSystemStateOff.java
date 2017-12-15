package ru.sbt.mipt.oop;

public class AlarmSystemStateOff implements AlarmSystemState{
    private final AlarmSystem systemState;

    public AlarmSystemStateOff(AlarmSystem systemState) {
        this.systemState = systemState;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.OFF;
    }

    @Override
    public void turnOn() {
        systemState.setSystemState(new AlarmSystemStateWaitForPassword(systemState));
    }

    @Override
    public void turnOff() {

    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {

    }
}
