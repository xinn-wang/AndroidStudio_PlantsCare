package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by Kinh Truong
 * @author  Kinh Truong
 * This activity is for displaying output of already watered date of plants
 * @version 1: Added navigation button
 * @version 2: Added ListView and set adapter to display history of watered plants
 */
public class HistoryActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private ListView history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        // initiate
        backBtn = findViewById(R.id.backBtn);
        history = findViewById(R.id.recordsListView);
        //set adapter
        history.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                HistoryList.getInstance().getHistoryList()
        ));
        // back to Main activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(HistoryActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

    }
}