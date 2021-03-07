package fi.group11.plantscare;

import java.util.ArrayList;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for creating a singleton list for storing database
 * @version 1: Added required variable and constructor for creating a singlton class
 * @version 2: Added demo database
 */
public class PlantList {
    private static final PlantList instance = new PlantList();
    private ArrayList<Plant> plants;

    /**
     * Get the singleton instance of the class
     * @return PlantList singleton instance of the class
     */
    public static PlantList getInstance() {
        return instance;
    }

    /**
     * Private constructor for creating the only one ArrayList as database
     */
    private PlantList() {
        this.plants = new ArrayList<>();
        plants.add(new Plant("rose", "flower", 3, "6-8 hours/day", 27));
        plants.add(new Plant("sunflower", "flower", 1, "3 hours/day", 40));
    }

    /**
     * Get database plant's list
     * @return ArrayList(Plant type ArrayList as database)
     */
    public ArrayList<Plant> getPlants() {
        return this.plants;
    }
}
