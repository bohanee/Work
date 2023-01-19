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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

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
        /*
        //REALTIME
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String ShopNumberINT, EmployeeNumberINT, ActualEmployeePhoneNumbers;
        DatabaseReference Shops, BuisnessCode_PhoneNumber, BuisnessManName,ShopNumberRef, StoreCode, Address, EmailID, Employees,EmployeeNumberRef, PhNum_EmployeeName, PINCode, StoreName;
        Shops = database.getReference("Shops");
        BuisnessCode_PhoneNumber = Shops.child("8111952240_BUISNESS-CODE");
        BuisnessManName = BuisnessCode_PhoneNumber.child("NAME");
        BuisnessManName.setValue("Jonathan Chacko");
        ShopNumberINT = 1+"";
        ShopNumberRef = BuisnessCode_PhoneNumber.child(ShopNumberINT+"");
        StoreCode = ShopNumberRef.child("STORE-CODE");
        Address = StoreCode.child("ADDRESS");
        Address.setValue("SB Road");
        EmailID = StoreCode.child("EMAIL-ID");
        EmailID.setValue("jcp99gamer@gmail.com");
        Employees = StoreCode.child("Employees");
        EmployeeNumberINT = 1+"";
        EmployeeNumberRef = Employees.child(EmployeeNumberINT+"");
        ActualEmployeePhoneNumbers = "7905119512";
        PhNum_EmployeeName = EmployeeNumberRef.child(ActualEmployeePhoneNumbers);
        PhNum_EmployeeName.setValue("Harshit Rai");
        PINCode = StoreCode.child("PIN CODE");
        PINCode.setValue("411016");
        StoreName = StoreCode.child("STORE-NAME");
        StoreName.setValue("sHOPE");
        */

        /*
        //FIRESTORE
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        */


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