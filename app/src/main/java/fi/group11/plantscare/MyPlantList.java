package fi.group11.plantscare;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for creating a singleton list for storing user's plants
 * @version 1: Added required variable, constructor and getter
 * @version 2: Added addPlant and addAllPlant methods for saving and loading data using sharePreferences
 */
public class MyPlantList {
    private static final MyPlantList instance = new MyPlantList();
    ArrayList<Plant> myPlants;

    /**
     * Get the singleton instance of the class
     * @return MyPlantList singleton instance of the class
     */
    public static MyPlantList getInstance() {
        return instance;
    }

    /**
     * Private constructor for creating the only one ArrayList as user's plant list
     */
    private MyPlantList() {
        myPlants = new ArrayList<>();
    }

    /**
     * Get user's plant list
     * @return ArrayList(Plant type ArrayList as user plant list)
     */
    public ArrayList<Plant> getMyPlants() {
        return this.myPlants;
    }

    /**
     * Add specific plant into user's plant list
     * @param p Plant(specific plant added from app's menu or manually by filling a form)
     */
    public void addPlant(Plant p) {
        this.myPlants.add(p);
    }

    /**
     * Add a list of plants into user's plant list
     * @param plants List(list of plants passing to user's plant list in Shareprefereces)
     */
    public void addAllPlant(List<Plant> plants) {
        if(this.myPlants.isEmpty()) {
            this.myPlants.addAll(plants);
        }
    }

}
