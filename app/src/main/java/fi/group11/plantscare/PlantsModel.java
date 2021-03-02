package fi.group11.plantscare;

public class PlantsModel {
    private int Id;
    private String Name;
    private String Type;
    private String Info;
    private String WaterNeeds;
    private String SunPreference;
    private String Temperature;

    public PlantsModel(int id, String name, String type, String info, String waterNeeds, String sunPreference, String temperature) {
        Id = id;
        Name = name;
        Type = type;
        Info = info;
        WaterNeeds = waterNeeds;
        SunPreference = sunPreference;
        Temperature = temperature;
    }

    public PlantsModel() {
    }

    @Override
    public String toString() {
        return "PlantsModel{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Info='" + Info + '\'' +
                ", WaterNeeds='" + WaterNeeds + '\'' +
                ", SunPreference='" + SunPreference + '\'' +
                ", Temperature='" + Temperature + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getWaterNeeds() {
        return WaterNeeds;
    }

    public void setWaterNeeds(String waterNeeds) {
        WaterNeeds = waterNeeds;
    }

    public String getSunPreference() {
        return SunPreference;
    }

    public void setSunPreference(String sunPreference) {
        SunPreference = sunPreference;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }
}
