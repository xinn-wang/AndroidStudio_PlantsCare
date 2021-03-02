package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MyPlantActivity extends AppCompatActivity {
    private Button reminderBtn;
    private ImageButton chooseWayBtn, backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplants);

        reminderBtn = findViewById(R.id.reminderBtn);
        chooseWayBtn = findViewById(R.id.chooseWayBtn);
        backBtn = findViewById(R.id.backBtn);
        //Launch reminder activity onClick
        reminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reminder = new Intent(MyPlantActivity.this, ReminderActivity.class);
                startActivity(reminder);
            }
        });
        //Launch add plant activity onClick
        chooseWayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseWay = new Intent(MyPlantActivity.this, ChooseActivity.class);
                startActivity(chooseWay);
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

