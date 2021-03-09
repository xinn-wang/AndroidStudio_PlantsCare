package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by Kinh Truong
 * @author  Kinh Truong
 * This activity is for storing user's myPlant's list
 * @version 1: Added navigation function for buttons
 * @version 2: Added ListView to display user's myPlant's list
 * @version 3: Added sharedPreferences and clearBtn to clear user's plant list
 * @version 4: Modified loadData() method
 *
 */
public class MyPlantActivity extends AppCompatActivity {
    private Button clearBtn;
    private ImageButton addPlantBtn, backBtn;
    private ListView myPlants;
    public static final String EXTRA_POSITION = "fi.group11.plantscare.EXTRA_POSITION";
    protected static final String SHARED_PRE = "sharedPreferences";
    protected static final String MY_PLANT_LIST = "myPlantList";
    //private ArrayList<Plant> userPlantList;
    private ArrayAdapter<Plant> myPlantAdapter;


    //How can I save data in addPlant database and manually

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplants);
        loadData();

        //initiate
        myPlants = findViewById(R.id.myPlantsList);
        clearBtn = findViewById(R.id.clearBtn );
        addPlantBtn = findViewById(R.id.addPlantBtn);
        backBtn = findViewById(R.id.backBtn);

        //Set array adapter for myPlantList ListView
         myPlantAdapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                MyPlantList.getInstance().getMyPlants()
        );
        myPlants.setAdapter(myPlantAdapter);
        //myPlantAdapter.notifyDataSetChanged();

        myPlants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent reminderData = new Intent(MyPlantActivity.this, ReminderActivity.class);
                reminderData.putExtra(EXTRA_POSITION, Integer.toString(position));
                startActivity(reminderData);
            }
        });

        //clear user's plant list
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPlantList.getInstance().getMyPlants().clear();
                myPlantAdapter.notifyDataSetChanged();
            }
        });
        //Launch add plant activity onClick
        addPlantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlant = new Intent(MyPlantActivity.this, AddPlantActivity.class);
                startActivity(addPlant);
            }
        });
        //Back to homepage onClick
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(MyPlantActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

    }

    /**
     * Save data using sharePreferences
     */
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PRE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(MyPlantList.getInstance().getMyPlants());
        editor.putString(MY_PLANT_LIST, json);
        editor.apply();
    }
    /**
     * Load data using sharePreferences
     */
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PRE, MODE_PRIVATE);
        Gson gson = new Gson();
        TypeToken type = new TypeToken<ArrayList<Plant>>() {};
        String json = sharedPreferences.getString(MY_PLANT_LIST, null);
        Log.d("saveData", json);
        ArrayList<Plant> userPlantList = gson.fromJson(json, type.getType());

        if(userPlantList != null || !userPlantList.isEmpty()) {
            MyPlantList.getInstance().addAllPlant(userPlantList);
        }
    }

    /**
     * Call saveData method
     */
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

}

