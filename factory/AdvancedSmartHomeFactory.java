package factory;

import decorator.LoggingDecorator;
import devices.DeviceStatus;
import devices.Light;
import devices.SmartDevice;
import devices.Thermometer;

//Fabric for adv devices
class AdvancedSmartHomeFactory implements SmartHomeFactory {
    @Override
    public SmartDevice createLight(String location) {
        return new LoggingDecorator(new Light(location));
    }


    @Override
    public SmartDevice createThermometer(String location) {
        return new SmartThermostat(location);
    }
}





class SmartThermostat extends Thermometer {
    public SmartThermostat(String location) {
        super(location);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(" Analyzing weather and adjusting temperature...");
    }

    @Override
    public DeviceStatus getStatus() {
        DeviceStatus status = super.getStatus();
        return new DeviceStatus(status.getName(), status.isOn(), status.getAdditionalInfo() + " (Optimized)");
    }
}
