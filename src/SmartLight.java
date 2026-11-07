package responsi;

public class SmartLight extends IoTDevice implements RemoteControllable {
    private int brightness;

    public SmartLight(String deviceId, String name) {
        super(deviceId, name);
        this.brightness = 0;
    }

    @Override
    public void processSensorData() {
        if (getPowerState()) {
            if (this.brightness < 50) {
                System.out.println("Cahaya ruangan redup. Meningkatkan kecerahan...");
                this.brightness = 100;
            } else {
                System.out.println("Cahaya ruangan sudah cukup terang.");
            }
        } else {
            System.out.println("Lampu pintar mati.");
        }
    }

    @Override
    public void turnOn() { setPowerState(true); this.brightness = 100; System.out.println(getName() + " menyala."); }
    @Override
    public void turnOff() { setPowerState(false); this.brightness = 0; System.out.println(getName() + " mati."); }
}
