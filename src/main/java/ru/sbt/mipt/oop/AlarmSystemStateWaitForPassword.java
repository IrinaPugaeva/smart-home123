package ru.sbt.mipt.oop;

public class AlarmSystemStateWaitForPassword implements AlarmSystemState {

    public final AlarmSystem alarmSystem;

    public AlarmSystemStateWaitForPassword(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {

    }

    @Override
    public void enterPassword(String password) {
        if (password.equals("PASSWORD")) {
            alarmSystem.setSystemState(new AlarmSystemStateOff(alarmSystem));
        }else{
            alarmSystem.setSystemState(new AlarmSystemStateAlarm(alarmSystem));
        }

    }
}
