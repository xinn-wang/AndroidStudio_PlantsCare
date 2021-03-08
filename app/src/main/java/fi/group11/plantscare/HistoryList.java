package fi.group11.plantscare;

import java.util.ArrayList;

/**
 *Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for generating a singleton list of history of already watered plants
 * @version 1: Added required variable, constructor and getter
 */
public class HistoryList {
    private static final HistoryList instance = new HistoryList();
    ArrayList<String> historyList;

    /**
     * Get the singleton instance of the class
     * @return HistoryList singleton instance of the class
     */
    public static HistoryList getInstance() {
        return instance;
    }

    /**
     * Private constructor for creating the only one ArrayList for history output
     */
    private HistoryList() {
        historyList = new ArrayList<>();
    }

    /**
     * Get history's list
     * @return ArrayList(Plant type ArrayList as history list)
     */
    public ArrayList<String> getHistoryList() {
        return this.historyList;
    }

}

