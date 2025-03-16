package devices;

public class Light implements SmartDevice {
    private String name;
    private boolean isOn = false;
    public Light(String name){
        this.name = name;
    }

    @java.lang.Override
    public void turnOn() {
        isOn = true;
        System.out.println("devices.Light on");
    }

    @java.lang.Override
    public void turnOff() {
        isOn = false;
        System.out.println("devices.Light off");
    }

    @java.lang.Override
    public DeviceStatus getStatus() {
        return new DeviceStatus(name + " devices.Light", isOn, "Brightness: 80%");
    }
}
