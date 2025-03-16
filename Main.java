import devices.*;
import composite.*;
import decorator.*;
import factory.*;
import facade.*;
import adapter.*;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        SmartHomeFactory factory = new BasicSmartHomeFactory();

        Light livingRoomLight = (Light) factory.createLight("Living Room Light");
        Thermometer livingRoomThermometer = (Thermometer) factory.createThermometer("Living Room Thermometer");
        SmartDevice smartLock = new LegacySystemAdapter(new OldSmartLock());

        Room livingRoom = new Room("Living Room");
        livingRoom.addDevice(livingRoomLight);
        livingRoom.addDevice(livingRoomThermometer);

        Room bedroom = new Room("Bedroom");
        bedroom.addDevice(factory.createLight("Bedroom Light"));

        SmartDevice loggedLight = new LoggingDecorator(livingRoomLight);
        SmartDevice scheduledThermometer = new ScheduledOperationDecorator(livingRoomThermometer, LocalTime.of(6, 0), LocalTime.of(22, 0));

        SmartHomeController controller = new SmartHomeController();
        controller.addDevice(loggedLight);
        controller.addDevice(scheduledThermometer);
        controller.addDevice(smartLock);
        controller.addDevice(livingRoom);
        controller.addDevice(bedroom);

        System.out.println("Turning on all lights...");
        controller.turnAllLightsOn();

        System.out.println("\nSetting global temperature...");
        controller.setGlobalTemperature(22);

        System.out.println("\nLocking all doors...");
        controller.lockAllDoors();

        System.out.println("\nSmart Home Status Report:");
        System.out.println(controller.getSystemStatusReport());

        System.out.println("\nChecking scheduled operations...");
        ((ScheduledOperationDecorator) scheduledThermometer).checkAndRunSchedule();

        System.out.println("\nTurning everything OFF...");
        turnOffDevices(controller);

        System.out.println("\nSmart Home Status Report After Shutdown:");
        System.out.println(controller.getSystemStatusReport());
    }

    private static void turnOffDevices(SmartHomeController controller) {
        for (SmartDevice device : controller.getDevices()) {
            if (device instanceof Room) {
                ((Room) device).turnOff();
            } else {
                device.turnOff();
            }
        }
    }
}
