package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.time.LocalDate;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activiti is for user to add plant anually to their plant's list by filling out a form
 * @version 1: Added button onClick listener as a demo for the activity
 * @version 2: Added EdiText manipulation, passing EditText values, set up add plant manually
 * @version 3: Added empty field condition using isEmpty() method to avoid crash
 */
public class AddPlantFromUser extends AppCompatActivity {
    private Button addManual;
    private EditText name, type, waterCycle, sunPref, temperature;
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_from_user);

        //initiate
        name = findViewById(R.id.nameEtxt);
        type = findViewById(R.id.typeEtxt);
        waterCycle = findViewById(R.id.waterCycleEtxt);
        sunPref = findViewById(R.id.sunPrefEtxt);
        temperature = findViewById(R.id.temperatureEtxt);
        addManual = findViewById(R.id.addManual);
        backBtn = findViewById(R.id.backBtn);
        //set hint
        name.setHint(R.string.name);
        type.setHint(R.string.type);
        waterCycle.setHint(R.string.needsWater);
        sunPref.setHint(R.string.sunPref);
        temperature.setHint(R.string.temperature);
        addManual.setText(R.string.anp);

        //back to add plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlant = new Intent(AddPlantFromUser.this, AddPlantActivity.class);
                startActivity(addPlant);
            }
        });
        //test manual add button
        addManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || type.getText().toString().isEmpty()
                        || waterCycle.getText().toString().isEmpty()
                        || sunPref.getText().toString().isEmpty() || temperature.getText().toString().isEmpty()) {
                    Toast.makeText(AddPlantFromUser.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    LocalDate creationDay = LocalDate.now();
                    MyPlantList.getInstance().getMyPlants().add
                            (new Plant(name.getText().toString(), type.getText().toString(),
                                    Integer.valueOf(waterCycle.getText().toString()),
                                    sunPref.getText().toString(),
                                    Integer.valueOf(temperature.getText().toString())));
                    MyPlantList.getInstance().getMyPlants().get(MyPlantList.getInstance().getMyPlants().size() - 1).setFirstDay(creationDay);
                    Toast.makeText(AddPlantFromUser.this, "Added to My Plants" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}