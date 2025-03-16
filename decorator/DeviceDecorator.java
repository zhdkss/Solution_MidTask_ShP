package decorator;

import devices.DeviceStatus;
import devices.SmartDevice;

public abstract class DeviceDecorator implements SmartDevice{
    protected SmartDevice device;
    public DeviceDecorator(SmartDevice device){
        this.device = device;
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public DeviceStatus getStatus() {
        return device.getStatus();
    }
}
