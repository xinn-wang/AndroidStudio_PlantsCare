package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSmoothScroller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;

/**
 * Created by Kinh Truong
 * @author  Kinh Truong
 * This activity is for displaying 2 options of adding plant as 2 buttons
 * @version 1: Added button navigation function
 * @version 2: Added listview for database, ListView can be clicked to add plant to user's list
 * @version 3: Moved database ListView to another activity, created 2 new buttons for new navigation
 */
public class AddPlantActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button addFromDatabase, addManually;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants);
        //initiate
        backBtn = findViewById(R.id.backBtn);
        addFromDatabase = findViewById(R.id.addFromDatabase);
        addManually = findViewById(R.id.addManually);

        //lauch/back to MyPlant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(AddPlantActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });
        //launch AddFromDatabase activity
        addFromDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlantFromDatabase = new Intent(AddPlantActivity.this, AddPlantFromDatabase.class);
                startActivity(addPlantFromDatabase);
            }
        });
        //launch AddFromUser activity
        addManually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlantFromUser = new Intent(AddPlantActivity.this, AddPlantFromUser.class);
                startActivity(addPlantFromUser);
            }
        });

    }
}