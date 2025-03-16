package devices;

public class Thermometer implements SmartDevice {
    private String location;
    private boolean isOn;
    private int temperature;

    public Thermometer(String location) {
        this.location = location;
        this.temperature = 22; // По умолчанию 22°C
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(location + " thermostat is turned on");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(location + " thermostat is turned off");
    }

    @Override
    public DeviceStatus getStatus() {
        return new DeviceStatus("Thermostat", isOn, "Temp: " + temperature + "°C");
    }
    public void setTemperature(int temperature) {
        if (isOn) {
            this.temperature = temperature;
            System.out.println(location + " thermostat set to " + temperature + "°C");
        } else {
            System.out.println("Cannot set temperature: " + location + " thermomoter is OFF");
        }
    }
}
