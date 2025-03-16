package decorator;

import devices.DeviceStatus;
import devices.SmartDevice;

import java.time.LocalTime;

public class ScheduledOperationDecorator extends DeviceDecorator {
    private LocalTime onTime;
    private LocalTime offTime;

    public ScheduledOperationDecorator(SmartDevice device, LocalTime onTime, LocalTime offTime) {
        super(device);  // ✅ Исправлено: Убираем ошибочный параметр "time"
        this.onTime = onTime;
        this.offTime = offTime;
    }

    public void checkAndRunSchedule() {
        LocalTime now = LocalTime.now();
        if (now.isAfter(onTime) && now.isBefore(offTime)) {
            if (!device.getStatus().isOn()) {
                System.out.println("[SCHEDULE] Turning ON " + device.getStatus().getName());
                super.turnOn();
            }
        } else {
            if (device.getStatus().isOn()) {
                System.out.println("[SCHEDULE] Turning OFF " + device.getStatus().getName());
                super.turnOff();
            }
        }
    }

    @Override
    public DeviceStatus getStatus() {
        DeviceStatus status = super.getStatus();
        return new DeviceStatus(
                status.getName(),
                status.isOn(),
                status.getAdditionalInfo() + " (Scheduled ON: " + onTime + ", OFF: " + offTime + ")"
        );
    }
}
