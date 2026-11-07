package responsi;

public class SmartThermostat extends IoTDevice implements RemoteControllable, NetworkConnectable {
    private int currentTemp;
    private boolean connected;

    public SmartThermostat(String deviceId, String name) {
        super(deviceId, name);
        this.currentTemp = 25;
        this.connected = false;
    }

    public void setTemperature(int temp) { this.currentTemp = temp; }

    @Override
    public void processSensorData() {
        if (getPowerState()) {
            if (this.currentTemp > 30) {
                System.out.println("Suhu terlalu panas (" + this.currentTemp + "C). Mendinginkan ruangan...");
                this.currentTemp = 25;
            } else {
                System.out.println("Suhu normal (" + this.currentTemp + "C).");
            }
        } else {
            System.out.println("Perangkat mati, sensor tidak bekerja.");
        }
    }

    @Override
    public String getDeviceInfo() {
        return super.getDeviceInfo() + " | Temp: " + this.currentTemp + "C";
    }

    @Override
    public void turnOn() { setPowerState(true); System.out.println(getName() + " menyala."); }
    @Override
    public void turnOff() { setPowerState(false); System.out.println(getName() + " mati."); }
    @Override
    public void connectToWiFi(String ssid) {
        this.connected = true;
        System.out.println(getName() + " terhubung ke " + ssid + " menggunakan " + PROTOCOL);
    }
    @Override
    public boolean isConnected() { return this.connected; }
}
