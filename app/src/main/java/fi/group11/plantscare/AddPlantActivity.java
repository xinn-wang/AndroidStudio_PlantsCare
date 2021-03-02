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
    DatabaseAccess newdb;
    private EditText editName, editType, editInfo, editWater, editSun, editTemp;
    private ImageButton backBtn,btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        newdb = new DatabaseAccess(this);

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
        databaseAccess.close();
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = newdb.insertData(editName.getText().toString(),
                                editType.getText().toString(), editInfo.getText().toString(),
                                editWater.getText().toString(), editSun.getText().toString(),
                                editTemp.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(AddPlantActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AddPlantActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
//    //Update Data of Database
//    public void updateData(){
//        btnUpdate.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                boolean isUpdate = mydb.updateData(editId.getText().toString(), editName.getText().toString(),
//                                editType.getText().toString(), editInfo.getText().toString(),
//                                editWater.getText().toString(), editSun.getText().toString(),
//                                editTemp.getText().toString() );
//                if(isUpdate == true)
//                    Toast.makeText(AddPlantActivity.this, "Data updated", Toast.LENGTH_LONG).show();
//                else
//                    Toast.makeText(AddPlantActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
//
//
//            }
//    }


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