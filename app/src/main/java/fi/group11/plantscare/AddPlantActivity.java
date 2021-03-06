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
 * @version 1: Added button navigation function
 * @version 2: Added listview for database, listview can be clicked to add plant to user's list
 * @version 3: Moved database listview to another activity, created 2 new buttons for new navigation
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

        //lauch/back to my plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(AddPlantActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });

        addFromDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlantFromDatabase = new Intent(AddPlantActivity.this, AddPlantFromDatabase.class);
                startActivity(addPlantFromDatabase);
            }
        });

        addManually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPlantFromUser = new Intent(AddPlantActivity.this, AddPlantFromUser.class);
                startActivity(addPlantFromUser);
            }
        });




        //Add new plant button will add that particular plant either from database or manually
        // Added into the singleton list in myplant
    }
}