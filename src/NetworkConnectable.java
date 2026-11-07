package responsi;

public interface NetworkConnectable {
    void connectToWiFi(String ssid);
    boolean isConnected();
}
