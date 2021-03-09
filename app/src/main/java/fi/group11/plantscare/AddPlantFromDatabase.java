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
import android.widget.Toast;

import com.google.gson.Gson;

import java.time.LocalDate;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for displaying the plant database of the app
 * @version 1: Added ListView to display database
 * @version 2: Added Toast message on added plant
 * @version 3: Added saveData() method for saving data in this activity, modified onClickListener
 */
public class AddPlantFromDatabase extends AppCompatActivity {
    private ListView plantList;
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_from_database);

        //initiate
        plantList = findViewById(R.id.plantList);
        backBtn = findViewById(R.id.backBtn);
        //back to add plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlant = new Intent(AddPlantFromDatabase.this, AddPlantActivity.class);
                startActivity(addPlant);
            }
        });
        //Set array adapter for plantList ListView
        plantList.setAdapter(new ArrayAdapter<Plant>(
                this,
                android.R.layout.simple_list_item_1,
                PlantList.getInstance().getPlants()
        ));
        // Add plant to user's plant list from app's menu onClick
        plantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LocalDate creationDay = LocalDate.now();
                Plant p = PlantList.getInstance().getPlants().get(position);
                //creationDay is converted to String because sharePreferences cannot save LocalDate type data
                p.setFirstDay(creationDay.toString());
                saveData(p);
                Toast.makeText(AddPlantFromDatabase.this, "Added to My Plants", Toast.LENGTH_SHORT).show();

            }
        });
    }
    /**
     * Save data using sharePreferences
     */
    public void saveData(Plant p) {
        SharedPreferences sharedPreferences = getSharedPreferences(MyPlantActivity.SHARED_PRE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        MyPlantList.getInstance().addPlant(p);
        String json = gson.toJson(MyPlantList.getInstance().getMyPlants());
        editor.putString(MyPlantActivity.MY_PLANT_LIST, json);
        Log.d("saveData", "sharepreferences " + p);
        editor.apply();
    }

}