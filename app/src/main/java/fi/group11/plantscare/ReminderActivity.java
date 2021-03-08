package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Kinh Truong
 * @author Kinh Truong
 * This activity is for displaying plant info and reminders for each specific plant in user'list
 * @version 1: Added buttons for navigation
 * @version 2: Setting loop and testing reminder function using Log.d
 * @version 3: Added get intent to retrieve and filter data, added listview for displaying reminder
 * @version 4: Added additional condition in while loop to send recorded watered days of the past to history activity
 */
public class ReminderActivity extends AppCompatActivity {
    private ArrayList<String> reminderList;
    private ListView reminderListView;
    private Button historyBtn;
    private ImageButton backBtn;
    private TextView reminderView, sunPref, temperature, type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        //initiate
        reminderView = findViewById(R.id.r);
        sunPref = findViewById(R.id.sunPref);
        temperature = findViewById(R.id.temperature);
        type = findViewById(R.id.type);
        reminderListView = findViewById(R.id.reminderListView);
        reminderList = new ArrayList<>();
        //Set array adapter for Reminder ListView
        reminderListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                reminderList
        ));
        //Retrieve intent from MyPlantActivity
        Intent reminderData = getIntent();
        int position = Integer.valueOf(reminderData.getStringExtra(MyPlantActivity.EXTRA_POSITION));
        //Set applicable reminders
        LocalDate today = LocalDate.now();
        int i = 0;
        reminderView.setText(MyPlantList.getInstance().getMyPlants().get(position).toString());
        sunPref.setText(MyPlantList.getInstance().getMyPlants().get(position).getSunPref());
        temperature.setText(Integer.toString(MyPlantList.getInstance().getMyPlants().get(position).getTemperature()));
        type.setText(MyPlantList.getInstance().getMyPlants().get(position).getType());
        while (true) {
            //get the value of the first day that specific plant is added to user's plant list
            LocalDate creationDay = MyPlantList.getInstance().getMyPlants().get(position).getFirstDay();
            //get the watering cycle(days/time) of the plant
            int interval = MyPlantList.getInstance().getMyPlants().get(position).getWateringCycle();
            LocalDate nextCycle = creationDay.plusDays((i++) * interval);

            if (nextCycle.compareTo(today) >= 0 && nextCycle.compareTo(today) <= 6) {
                reminderList.add(MyPlantList.getInstance().getMyPlants().get(position).toString()
                        + "(wateringDay): " + nextCycle);
            } else if (nextCycle.compareTo(today) >= -6 && nextCycle.compareTo(today) < 0) {
                HistoryList.getInstance().getHistoryList().add(
                        MyPlantList.getInstance().getMyPlants().get(position).toString()
                                + "(wateringDay): " + nextCycle);
            } else if (nextCycle.compareTo(today) > 6) {
                break;
            }

        }

        //initiate buttons
        historyBtn = findViewById(R.id.btn_h2);
        backBtn = findViewById(R.id.backBtn);
        //launch history activity onClick
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent history = new Intent(ReminderActivity.this, HistoryActivity.class);
                startActivity(history);
            }
        });
        //back to homepage onClick
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ReminderActivity.this, MyPlantActivity.class);
                startActivity(back);
            }
        });

    }
}