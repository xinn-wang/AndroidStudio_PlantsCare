package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class ReminderActivity extends AppCompatActivity {
    private Button historyBtn;
    private ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

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
                Intent back = new Intent(ReminderActivity.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
}