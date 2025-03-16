package adapter;

import devices.DeviceStatus;
import devices.SmartDevice;

public class LegacySystemAdapter implements SmartDevice {
    private final OldSmartLock oldSmartLock;

    public LegacySystemAdapter(OldSmartLock oldSmartLock) {
        this.oldSmartLock = oldSmartLock;
    }

    @Override
    public void turnOn() {
        oldSmartLock.unlock();
    }

    @Override
    public void turnOff() {
        oldSmartLock.lock();
    }

    @Override
    public DeviceStatus getStatus() {
        boolean isLocked = oldSmartLock.isLocked();
        return new DeviceStatus(
                "Smart Lock",   // Название устройства
                !isLocked,      // Если замок заперт → OFF, если открыт → ON
                isLocked ? "Lock - LOCKED" : "Lock - UNLOCKED" // Доп. информация
        );
    }
}
