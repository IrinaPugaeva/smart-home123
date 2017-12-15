package ru.sbt.mipt.oop;

public class AlarmSystemStateAlarm implements AlarmSystemState {
        private final AlarmSystem systemState;

    public AlarmSystemStateAlarm(AlarmSystem systemState) {
        this.systemState = systemState;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ALARM;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {
        systemState.setSystemState(new AlarmSystemStateWaitForPassword(systemState));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {
        systemState.setSystemState(new AlarmSystemStateWaitForPassword(systemState));
    }
}
