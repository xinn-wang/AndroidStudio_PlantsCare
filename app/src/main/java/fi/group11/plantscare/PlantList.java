package fi.group11.plantscare;

import java.util.ArrayList;

public class PlantList {
    private static final PlantList instance = new PlantList();
    private ArrayList<Plant> plants;

    public static PlantList getInstance() {
        return instance;
    }

    private PlantList() {
        this.plants = new ArrayList<>();
        plants.add(new Plant("rose", "flower", 3, "6-8 hours/day", "27°C"));
        plants.add(new Plant("sunflower", "flower", 1, "3 hours/day", "40°C"));
    }

    public ArrayList<Plant> getPlants() {
        return this.plants;
    }
}
