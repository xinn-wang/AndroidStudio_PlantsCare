package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Kinh Truong
 * @author  Kinh Truong
 * This activity is for displaying output of already watered date for specific plant
 */
public class HistoryActivity extends AppCompatActivity {
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        // back to home page onClick
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(HistoryActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

    }
}