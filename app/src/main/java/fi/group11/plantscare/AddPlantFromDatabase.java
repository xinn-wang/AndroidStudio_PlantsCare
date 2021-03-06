package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.time.LocalDate;

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

                MyPlantList.getInstance().getMyPlants().add(PlantList.getInstance().getPlants()
                        .get(position));
                LocalDate creationDay = LocalDate.now();
                MyPlantList.getInstance().getMyPlants().get(MyPlantList.getInstance().getMyPlants().size() - 1).setFirstDay(creationDay);

            }
        });
    }
}