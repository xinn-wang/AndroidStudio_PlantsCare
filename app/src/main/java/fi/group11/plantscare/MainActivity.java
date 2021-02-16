package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Homepage button methods to launch corresponding activity
    public void myplantBtn(View v) {
        Intent myplant = new Intent(this, MyPlantActivity.class);
        startActivity(myplant);
    }

    public void reminderBtn(View v) {
        Intent reminder = new Intent(this, ReminderActivity.class);
        startActivity(reminder);
    }

    public void historyBtn(View v) {
        Intent history = new Intent(this, HistoryActivity.class);
        startActivity(history);
    }
}