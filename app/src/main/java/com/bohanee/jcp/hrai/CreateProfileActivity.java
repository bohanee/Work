package com.bohanee.jcp.hrai;
//CREATEPROFILEACTIVITY
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateProfileActivity extends AppCompatActivity {
    EditText Name;
    TextView PhoneNumber;
    Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        Name=findViewById(R.id.name_et);
        PhoneNumber=findViewById(R.id.ph_no_et); //ToDo, Receive The Data from PhoneAuthActivity.java and Keep it Locked... (DB)
        saveButton=findViewById(R.id.save_btn);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToDo, Send The Data into a Package (DB)...
                /*String name = Name.getText().toString();
                String phNo = PhoneNumber.getText().toString();*/
                Intent intent = new Intent(CreateProfileActivity.this, JoinBusinessActivity.class);
                startActivity(intent);
            }
        });
    }
}