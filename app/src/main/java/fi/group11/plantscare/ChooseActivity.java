package fi.group11.plantscare;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseActivity extends AppCompatActivity {
    MyDatabaseHelper mydb;
    private ImageButton backBtn;
    private Button addManual,addFromDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        backBtn = findViewById(R.id.backBtn);
        addManual = findViewById(R.id.add_manul);
        addFromDatabase = findViewById(R.id.add_fromDatabase);
        //setAddFromDatabase();
        //lauch/back to my plant activity
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myplant = new Intent(ChooseActivity.this, MyPlantActivity.class);
                startActivity(myplant);
            }
        });


        //go to add plant activity
        addManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addplant = new Intent(ChooseActivity.this, AddPlantActivity.class);
                startActivity(addplant);
            }
        });
    }
//    public void setAddFromDatabase(){
//        addFromDatabase.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor res = mydb.getAllData();
//                if(res.getCount() == 0){
//                    showMessage("Error", "Nothing found");
//                    return;
//                }
//
//                StringBuffer buffer = new StringBuffer();
//                while(res.moveToNext()){
//                    buffer.append("Id : "+ res.getString(0)+ "\n");
//                    buffer.append("Name : "+ res.getString(1)+ "\n");
//                    buffer.append("Type : "+ res.getString(2)+ "\n");
//                    buffer.append("Info : "+ res.getString(3)+ "\n");
//                    buffer.append("WaterNeeds : "+ res.getString(4)+ "\n");
//                    buffer.append("SunPreference : "+ res.getString(5)+ "\n");
//                    buffer.append("Temperature: "+ res.getString(6)+ "\n\n");
//                }
//                //show all data
//                showMessage("Data",buffer.toString());
//
//            }
//        }
//        );
//
//    }
//    public void showMessage(String title, String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }
}