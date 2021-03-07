package fi.group11.plantscare;

import java.util.ArrayList;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for creating a singleton list for storing user's plants
 * @version 1: Added required variable, constructor and getter
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

}
