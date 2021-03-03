package fi.group11.plantscare;

import java.util.ArrayList;

public class MyPlantList {
    private static final MyPlantList instance = new MyPlantList();
    ArrayList<Plant> myPlants;

    public static MyPlantList getInstance() {
        return instance;
    }

    private MyPlantList() {
        myPlants = new ArrayList<>();
    }

    public ArrayList<Plant> getMyPlants() {
        return this.myPlants;
    }

}
