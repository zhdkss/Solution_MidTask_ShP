package factory;

import devices.Light;
import devices.SmartDevice;
import devices.Thermometer;

public class BasicSmartHomeFactory implements SmartHomeFactory{
    @Override
    public SmartDevice createLight(String location){
        return new Light(location);

    }
    @Override
    public SmartDevice createThermometer(String location){
        return new Thermometer(location);
    }

}
