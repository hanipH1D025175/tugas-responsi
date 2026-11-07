package responsi;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN SISTEM IOT KAMAR KOST ===\n");

        RemoteControllable thermostat = new SmartThermostat("TH-01", "Thermostat Kamar");
        thermostat.turnOn();

        SmartThermostat st = (SmartThermostat) thermostat;
        st.connectToWiFi("Kost_Network");

        System.out.println(st.getDeviceInfo());

        st.setTemperature(32);
        st.processSensorData();
        System.out.println("Setelah diproses: " + st.getDeviceInfo());

        System.out.println("\n-----------------------------------\n");

        RemoteControllable light = new SmartLight("SL-01", "Lampu Belajar Pintar");
        light.turnOn();

        SmartLight sl = (SmartLight) light;
        sl.processSensorData();
        System.out.println(sl.getDeviceInfo());

        light.turnOff();
        sl.processSensorData();
    }
}
