package fi.group11.plantscare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button addManual,addFromDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        backBtn = findViewById(R.id.backBtn);
        //lauch/back to my plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(ChooseActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });

        addManual = findViewById(R.id.add_manul);
        addManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addplant = new Intent(ChooseActivity.this, AddPlantActivity.class);
                startActivity(addplant);
            }
        });
    }
}