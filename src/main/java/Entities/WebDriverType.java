package Entities;

public enum WebDriverType {
    CHROME("chrome"),
    SAFARI("safari"),
    FIREFOX("firefox");

    private String driverName;

    WebDriverType(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }
}
