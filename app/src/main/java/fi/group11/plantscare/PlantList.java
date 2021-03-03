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
        plants.add(new Plant("rose", "flower", 3, "NA", "NA"));
        plants.add(new Plant("sunflower", "flower", 1, "NA", "NA"));
    }

    public ArrayList<Plant> getPlants() {
        return this.plants;
    }
}
