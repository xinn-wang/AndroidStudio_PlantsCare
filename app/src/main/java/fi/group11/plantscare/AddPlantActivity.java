package fi.group11.plantscare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPlantActivity extends AppCompatActivity {
    MyDatabaseHelper mydb;
    EditText editName, editType, editInfo, editWater, editSun, editTemp;
    private ImageButton backBtn,btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants);
        mydb = new MyDatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editName_add);
        editType = (EditText) findViewById(R.id.editType_add);
        editInfo = (EditText) findViewById(R.id.editInfo_add);
        editWater = (EditText) findViewById(R.id.editWater_add);
        editSun = (EditText) findViewById(R.id.editSun_add);
        editTemp = (EditText) findViewById(R.id.editTemp_add);
        btnAddData = (ImageButton) findViewById(R.id.add);
        backBtn = findViewById(R.id.backBtn);
        AddData();
        Back();
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertData(editName.getText().toString(),
                                editType.getText().toString(), editInfo.getText().toString(),
                                editWater.getText().toString(), editSun.getText().toString(),
                                editTemp.getText().toString() );
                        if(isInserted = true)
                            Toast.makeText(AddPlantActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPlantActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
    public void Back(){
        //lauch/back to my plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(AddPlantActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });


    }
}