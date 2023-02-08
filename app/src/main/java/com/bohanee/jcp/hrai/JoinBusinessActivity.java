package com.bohanee.jcp.hrai;
//JoinBusinessActivity
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class JoinBusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_business);

        //FirebaseFirestore dbFIRESTORE = FirebaseFirestore.getInstance();
        FirebaseDatabase dbREALTIME = FirebaseDatabase.getInstance("https://bohanee-jcp-hrai-default-rtdb.asia-southeast1.firebasedatabase.app/");
        /*String PhoneNumberBusinessMan= "8111953340"; //ToDo, Get the Number from the Previous Database and Enter it Here (DB)...
        int Number = 1;
        DatabaseReference myRef = dbREALTIME.getReference("Shops");
        DatabaseReference myRefBusinessCode = myRef.child(PhoneNumberBusinessMan);
        DatabaseReference myRefStoreCode = myRefBusinessCode.child(""+Number+"").child("StoreCode");
        DatabaseReference myRefEmployees = myRefStoreCode.child("Employees");
        Button setupBusiness= findViewById(R.id.pending_approvals_btn);
        Button joinBusiness= findViewById(R.id.multi_store_btn);*/
        setupBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinBusinessActivity.this, SetupBusinessActivity.class);
                startActivity(intent);
                /*myRefBusinessCode.child("NAME").setValue("Jonathan Chacko Pattasseril");
                myRefStoreCode.child("ADDRESS").setValue("SB Road");
                myRefStoreCode.child("EMAIL-ID").setValue("jcp99gamer@gmail.com");
                myRefStoreCode.child("PIN CODE").setValue("411016");
                myRefStoreCode.child("STORE-NAME").setValue("sHOPE");
                myRefEmployees.child("PHONENUMBER").setValue("EMPLOYEENAME");*/
            }
        });
        joinBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinBusinessActivity.this, BizStoreCodeActivity.class);
                startActivity(intent);
            }
        });

    }
}