package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import fi.group11.plantscare.R;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is the main acitivity and the homepage of the app
 * @version 1: Creating buttons navigation
 * @version 2: Modified button onClick listener using id
 */
public class MainActivity extends AppCompatActivity {
    private Button myPlantBtn, historyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initiate
        myPlantBtn = findViewById(R.id.btn_mp);
        historyBtn = findViewById(R.id.btn_h);

        myPlantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(MainActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent history = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(history);
            }
        });
    }


    public void reminderBtn(View v) {
        Intent reminder = new Intent(this, ReminderActivity.class);
        startActivity(reminder);
    }
}

