package responsi;

public abstract class IoTDevice {
    public static final String PROTOCOL = "MQTT-IoT";

    private final String deviceId;

    private String name;
    private boolean powerState;

    public IoTDevice(String deviceId) {
        this.deviceId = deviceId;
        this.name = "Unknown Device";
        this.powerState = false;
    }

    public IoTDevice(String deviceId, String name) {
        this.deviceId = deviceId;
        this.name = name;
        this.powerState = false;
    }

    public String getDeviceId() { return this.deviceId; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public boolean getPowerState() { return this.powerState; }
    public void setPowerState(boolean powerState) { this.powerState = powerState; }

    public String getDeviceInfo() {
        return "Device: " + this.name + " | ID: " + this.deviceId;
    }

    public void resetDevice() {
        this.powerState = false;
        System.out.println(this.name + " telah di-reset.");
    }

    public abstract void processSensorData();
}
