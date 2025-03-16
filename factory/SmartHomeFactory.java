package factory;

import devices.SmartDevice;

public interface SmartHomeFactory {
    SmartDevice createLight(String location);
    SmartDevice createThermometer(String location);
}
