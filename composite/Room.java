package composite;

import devices.DeviceStatus;
import devices.SmartDevice;

import java.util.ArrayList;
import java.util.List;

public class Room implements SmartDevice{
    private String name;
    private List<SmartDevice> devices = new ArrayList<>();
    public Room(String name){
        this.name = name;
    }
    public void addDevice(SmartDevice device){
        devices.add(device);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on all devices" + name +
                "...");
        for (SmartDevice device : devices){
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off all devices" + name +
                "...");
        for (SmartDevice device : devices){
            device.turnOff();
        }

    }

    @Override
    public DeviceStatus getStatus() {
        StringBuilder additionalInfo = new StringBuilder();
        boolean anyOn = false;
        for (SmartDevice device : devices){
            DeviceStatus status = device.getStatus();
            additionalInfo.append(status.toString()).append("\n");
            if (status.isOn()){
                anyOn = true;
            }
        }
        return new DeviceStatus(name + "composite.Room", anyOn, additionalInfo.toString());
    }
}
