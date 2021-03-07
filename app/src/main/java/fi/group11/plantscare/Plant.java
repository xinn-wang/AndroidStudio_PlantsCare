package fi.group11.plantscare;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Kinh Truong
 * @author  Kinh Truong
 * This activity is for setting up database and for data manipulation throughout the app
 * @version 1: Created instance variables, constructor, getters, setters and toString methods
 * @version 2: Added LocalDate type instance variable firstDay and its setter, getter
 */
public class Plant {
    private String name , type , sunPref;
    private int wateringCycle, temperature;
    private LocalDate firstDay;

    /**
     * Create a Plant type object with name, type, watering cycle, sun preference and temperature
     * @param name String name of the plant
     * @param type String type of the plant
     * @param wateringCycle int watering cycle of the plant(days/time)
     * @param sunPref String sun preference of the plant
     * @param temperature String ideal temperature of the plant
     */
    public Plant(String name, String type, int wateringCycle, String sunPref, int temperature) {
        this.name = name;
        this.type = type;
        this.wateringCycle = wateringCycle;
        this.sunPref = sunPref;
        this.temperature = temperature;
    }

    /**
     * Get plant's name
     * @return name of the plant
     */
    public String toString() {
        return name;
    }

    /**
     * Get plant's type
     * @return type of the plant
     */
    public String getType() {
        return type;
    }

    /**
     * Get watering cycle
     * @return watering cycle of the plant
     */
    public int getWateringCycle() {
        return wateringCycle;
    }

    /**
     * Get plant's sun preference
     * @return sun preference of the plant
     */
    public String getSunPref() {
        return sunPref;
    }

    /**
     * Get plant's ideal temperature
     * @return ideal temperature of the plant
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Get plant's first added day to myPlantList
     * @return first added dayo f the plant
     */
    public LocalDate getFirstDay() {
        return this.firstDay;
    }

    /**
     * Set plant's first added day
     * @param firstDay LocalDate plant's first added day
     */
    public void setFirstDay(LocalDate firstDay) {
        this.firstDay = firstDay;
    }

}
