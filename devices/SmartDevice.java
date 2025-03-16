package devices;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    DeviceStatus getStatus();
}
