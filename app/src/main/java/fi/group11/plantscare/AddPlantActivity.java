package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSmoothScroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AddPlantActivity extends AppCompatActivity {
    private ListView plantList;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants);

        plantList = findViewById(R.id.plantList);
        backBtn = findViewById(R.id.backBtn);
        //lauch/back to my plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(AddPlantActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });
        //Set array adapter for plantList ListView
        plantList.setAdapter(new ArrayAdapter<Plant> (
            this,
                android.R.layout.simple_list_item_1,
                PlantList.getInstance().getPlants()
        ));

        plantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyPlantList.getInstance().getMyPlants().add(PlantList.getInstance().getPlants().get(position));
                Toast.makeText(AddPlantActivity.this,
                        MyPlantList.getInstance().getMyPlants().get(position).toString() +
                                " selected", Toast.LENGTH_SHORT).show();
            }
        });



        //Add new plant button will add that particular plant either from database or manually
        // Added into the singleton list in myplant
    }
}