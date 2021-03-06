package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;

public class AddPlantFromUser extends AppCompatActivity {
    private Button testManual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plant_from_user);

        //initiate
        testManual = findViewById(R.id.testManual);
        //test manual add button
        testManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDate creationDay = LocalDate.now();
                MyPlantList.getInstance().getMyPlants().add(new Plant("Lavender","flower", 5, "1h/day", "90C"));
                MyPlantList.getInstance().getMyPlants().get(MyPlantList.getInstance().getMyPlants().size() - 1).setFirstDay(creationDay);
            }
        });
    }
}