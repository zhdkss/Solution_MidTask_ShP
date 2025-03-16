package devices;

public class DeviceStatus {
    private String name;
    private boolean isOn;
    private String additionalInfo;

    public DeviceStatus(String name, boolean isOn, String additionalInfo) {
        this.name = name;
        this.isOn = isOn;
        this.additionalInfo = additionalInfo;
    }
    public String getName(){
        return name;
    }
    public boolean isOn(){
        return isOn;
    }
    public String getAdditionalInfo(){
        return additionalInfo;

    }

    @Override
    public String toString() {
        return "- " + name + " | Status: " + (isOn ? "ON" : "OFF") + "\n" +
                "  | Info: " + additionalInfo + "\n";
    }
}
