package facade;

import adapter.LegacySystemAdapter;
import devices.Light;
import devices.SmartDevice;
import devices.Thermometer;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeController {
    private final List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }


    public void turnAllLightsOn() {
        for (SmartDevice device : devices) {
            if (device instanceof Light) {
                device.turnOn();
            }
        }
    }

    public void lockAllDoors() {
        for (SmartDevice device : devices) {
            if (device instanceof LegacySystemAdapter) {
                device.turnOff();
            }
        }
    }

    public String getSystemStatusReport() {
        StringBuilder report = new StringBuilder("Smart Home Status:\n");
        for (SmartDevice device : devices) {
            report.append(device.getStatus()).append("\n");
        }
        return report.toString();
    }
    public void setGlobalTemperature(int temperature) {
        for (SmartDevice device : devices) {
            if (device instanceof Thermometer) {
                ((Thermometer) device).setTemperature(temperature);
            }
        }
    }

}
