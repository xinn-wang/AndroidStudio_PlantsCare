package fi.group11.plantscare;

public class Plant {
    private String name;
    private String type;
    private int wateringCycle;
    private String sunPref;
    private String temperature;

    public Plant(String name, String type, int wateringCycle, String sunPref, String temperature) {
        this.name = name;
        this.type = type;
        this.wateringCycle = wateringCycle;
        this.sunPref = sunPref;
        this.temperature = temperature;
    }

    public String toString() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWateringCycle() {
        return wateringCycle;
    }

    public String getSunPref() {
        return sunPref;
    }

    public String getTemperature() {
        return temperature;
    }
}
