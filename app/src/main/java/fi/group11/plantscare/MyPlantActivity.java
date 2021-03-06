package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Kinh Truong
 * @author  Kinh Truong
 * This activity is for storing user's myPlant's list
 * @version 1: Added navigation function for buttons
 * @version 2: Added ListView to display user's myPlant's list
 *
 */
public class MyPlantActivity extends AppCompatActivity {
    private Button reminderBtn;
    private ImageButton addPlantBtn, backBtn;
    private ListView myPlants;
    public static final String EXTRA_POSTIION = "fi.group11.plantscare.EXTRA_DAYS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplants);
        //initiate
        myPlants = findViewById(R.id.myPlantsList);
        reminderBtn = findViewById(R.id.reminderBtn);
        addPlantBtn = findViewById(R.id.addPlantBtn);
        backBtn = findViewById(R.id.backBtn);

        //Set array adapter for myPlantList ListView
        myPlants.setAdapter(new ArrayAdapter<Plant>(
                this,
                android.R.layout.simple_list_item_1,
                MyPlantList.getInstance().getMyPlants()
        ));
        myPlants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent reminderData = new Intent(MyPlantActivity.this, ReminderActivity.class);
                reminderData.putExtra(EXTRA_POSTIION, Integer.toString(position));
                startActivity(reminderData);
            }
        });

        //Launch reminder activity onClick
        reminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}

