package com.bohanee.jcp.hrai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bohanee.jcp.hrai.database.AppDatabase;
import com.bohanee.jcp.hrai.database.AppExecutors;
import com.bohanee.jcp.hrai.database.User;
import com.bohanee.jcp.hrai.database.UserWithName;

public class CreateProfileActivity extends AppCompatActivity {
    EditText name;
    TextView phoneNumber;
    Button saveButton;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        name = findViewById(R.id.name_et);
        phoneNumber = findViewById(R.id.ph_no_tv);
        saveButton = findViewById(R.id.save_btn);
        db = AppDatabase.getInstance(this);


        loadUserFromDb();


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

        //FIRESTORE
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String BuisnessCode_PhoneNumberSTRING,
                SHOPCODE,
                EMPLOYEE_PhNum, DATE, TIME, HOURS, MIN, CUTOMER_NAME__CUSTOMER_PhNum, PRODUCT_NAME,
                ItemName,
                MONTH, DATE_DAY, STOCK_TIME, StockItemName;
        CollectionReference BuisnessCode_PhoneNumber_COLLECTION, StockCOLLECTION;
        DocumentReference EmployeesWaitingForVerificationData, ShopCodeDOCUMENT, TotalBillData, ProductData, CurrentStockTotalData, CurrentStockProductData, StockHistoryProductData;

        BuisnessCode_PhoneNumberSTRING = "Defined";
        SHOPCODE = "Defined";
        EMPLOYEE_PhNum = "Defined";
        DATE = "Defined";
            HOURS = "Defined";
            MIN = "Defined";
        TIME = "TIME("+HOURS+":"+MIN+")";
        CUTOMER_NAME__CUSTOMER_PhNum = "Defined";
        PRODUCT_NAME = "Defined";
        ItemName = "Defined";
        MONTH = "Defined";
        DATE_DAY = "Defined";
        STOCK_TIME = "Defined";
        StockItemName = "Defined";

        BuisnessCode_PhoneNumber_COLLECTION = db.collection(BuisnessCode_PhoneNumberSTRING);
            EmployeesWaitingForVerificationData = BuisnessCode_PhoneNumber_COLLECTION.document("Temp");
            ShopCodeDOCUMENT = BuisnessCode_PhoneNumber_COLLECTION.document(SHOPCODE);
                TotalBillData = ShopCodeDOCUMENT.collection(EMPLOYEE_PhNum).document(DATE).collection(TIME).document(CUTOMER_NAME__CUSTOMER_PhNum);
                    ProductData = TotalBillData.collection("Products").document(PRODUCT_NAME);
                StockCOLLECTION = ShopCodeDOCUMENT.collection("Stock");
                    CurrentStockTotalData = StockCOLLECTION.document("Current");
                        CurrentStockProductData = CurrentStockTotalData.collection("Stocks").document(ItemName);
                    StockHistoryProductData = StockCOLLECTION.document("Stock-History").collection(MONTH).document(DATE_DAY).collection(STOCK_TIME).document(StockItemName);

        Map<String, Object> billdata = new HashMap<>();
            billdata.put("DISCOUNT-MARGIN", 10+"%");
            billdata.put("PROFIT-MARGIN-AFTER-DISCOUNTS", 15+"%");
            billdata.put("TOTAL-BILL", 100);
            billdata.put("TOTAL-BILL-INCLUDING-DISCOUNTED-PRICE", 90);
            billdata.put("TOTAL-DISCOUNT", 10);
            billdata.put("TOTAL-PROFIT-AFTER-DISCOUNTS", 25);
        TotalBillData.set(billdata);

        String upc = "012345678901";
        Map<String, Object> productname = new HashMap<>();
            productname.put("CURRENT-CP", 50);
            productname.put("CURRENT-SP", 40);
            productname.put("MARKET-MRP", NULL);
            productname.put("PROFIT-MADE-%", 25+"%");
            productname.put("PROFIT-MADE-PER-PRODUCT", 10);
            productname.put("UPC-NUMBER", upc);
        ProductData.set(productname);

        String UPC = "012345678901";
        Map<String, Object> currentstocks = new HashMap<>();
            currentstocks.put("Value", "TOTAL-STOCK-VALUE");
        CurrentStockTotalData.set(currentstocks);

        Map<String, Object> itemname = new HashMap<>();
            itemname.put("CP", 15);
            itemname.put("QTY", 10);
            itemname.put("SP", 2);
            itemname.put("UNITS-MESSURE", "Grams");
            itemname.put("UPC-NUMBER", UPC);
        CurrentStockProductData.set(itemname);

        Map<String, Object> ITEMNAME = new HashMap<>();
            ITEMNAME.put("CostPrice", "TOTALHISTORICALCOSTPRICE");
            ITEMNAME.put("QTY", 10);
            ITEMNAME.put("SellingPrice", "TOTALHISTORICALSELLINGPRICE");
            ITEMNAME.put("TOTAL_VALUE", 1000);
        StockHistoryProductData.set(ITEMNAME);

        Map<String, Object> tempemployeedata = new HashMap<>();
            tempemployeedata.put("PHONENUMBER", "EMPLOYEENAME");
        EmployeesWaitingForVerificationData.set(tempemployeedata);
         */

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToDo, Send The Data into a Package (DB)...
                String receivedName = name.getText().toString();
                String receivedPhNo = phoneNumber.getText().toString();

                UserWithName userWithName = new UserWithName(receivedName, receivedPhNo);
                insertUserToDb(userWithName);

                Intent intent = new Intent(CreateProfileActivity.this, JoinBusinessActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadUserFromDb() {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                User returnedUser = db.userDao().loadUserById(0);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        phoneNumber.setText(returnedUser.getPhoneNo());

                    }
                });
            }
        });


    }

    private void insertUserToDb(UserWithName userWithName) {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                db.userWithNameDao().insertUserWithName(userWithName);
            }
        });
    }
}