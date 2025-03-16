# Smart Home Control System

## Project Description
This project is a smart home management system built using various design patterns. The program allows users to control devices (lights, thermometers, locks, etc.), group them into rooms, and apply decorators to extend their functionality.

## Main Features:
- Device control (turn on, turn off, get status)
- Grouping devices into rooms (**Composite** pattern)
- Adding logging and scheduling for devices (**Decorator** pattern)
- Using a factory to create smart devices (**Factory** pattern)
- Managing the system through a controller (**Facade** pattern)
- Adapting legacy devices (**Adapter** pattern)

## Project Structure:
- `devices/` - device classes (Light, Thermometer, SmartDevice, etc.)
- `composite/` - implementation of rooms that group devices
- `decorator/` - decorators for logging and scheduling
- `factory/` - factory for creating smart devices
- `facade/` - facade for system management
- `adapter/` - adapter for legacy systems
- `Main.java` - the entry point that tests the system functionality

## Development Process:
1. **Created the system framework**: Defined the `SmartDevice` interface and base device classes.
2. **Implemented the Composite pattern**: The `Room` class allows grouping devices.
3. **Added the Factory pattern**: A factory to create devices dynamically.
4. **Implemented Decorators**: `LoggingDecorator` for logging and `ScheduledOperationDecorator` for scheduled activation.
5. **Built a Facade**: `SmartHomeController` for easy system management.
6. **Developed an Adapter**: `LegacySystemAdapter` for integrating legacy devices.
7. **Testing**: `Main.java` ensures all components function correctly.
