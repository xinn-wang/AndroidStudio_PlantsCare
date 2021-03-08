package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.time.LocalDate;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for displaying the plant database of the app
 * @version 1: Added listview to display database
 * @version 2: Added Toast message on added plant
 */
public class AddPlantFromDatabase extends AppCompatActivity {
    private ListView plantList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_from_database);

        //initiate
        plantList = findViewById(R.id.plantList);
        //Set array adapter for plantList ListView
        plantList.setAdapter(new ArrayAdapter<Plant>(
                this,
                android.R.layout.simple_list_item_1,
                PlantList.getInstance().getPlants()
        ));

        plantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MyPlantList.getInstance().getMyPlants().add(PlantList.getInstance().getPlants().get(position));
                LocalDate creationDay = LocalDate.now();
                MyPlantList.getInstance().getMyPlants().get(MyPlantList.getInstance().getMyPlants().size() - 1).setFirstDay(creationDay);
                Toast.makeText(AddPlantFromDatabase.this, "Added to My Plants", Toast.LENGTH_SHORT).show();
            }
        });
    }

}