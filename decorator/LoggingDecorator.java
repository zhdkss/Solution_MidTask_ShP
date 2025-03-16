package decorator;

import devices.DeviceStatus;
import devices.SmartDevice;

public class LoggingDecorator extends DeviceDecorator {
    public LoggingDecorator(SmartDevice device) {
        super(device);  // ❌ Убираем time, он здесь не нужен!
    }

    @Override
    public void turnOn() {
        System.out.println("[LOG] Turning ON: " + device.getStatus().getName());
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("[LOG] Turning OFF: " + device.getStatus().getName());
        super.turnOff();
    }

    @Override
    public DeviceStatus getStatus() {
        DeviceStatus status = super.getStatus();
        return new DeviceStatus(status.getName(), status.isOn(), status.getAdditionalInfo() + " (Logged)");
    }
}
