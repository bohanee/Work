package com.bohanee.jcp.hrai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.database.Product;

import java.util.ArrayList;
import java.util.List;

public class BillingFragment extends Fragment implements CameraFragment.OnChildFragmentInteractionListener {

    FragmentTransaction fragmentTransactionB;
    private BillingRVAdapter adapter;
    private OnFragmentInteractionListener mListener;
    private Button cancelButton, proceedButton, fastForwardButton;
    private EditText discountAmtEdt, discountPercentEdt;
    private SwitchCompat camSwitch;
    private FrameLayout frameLayout;
    private EditText addUPCEdt;
    private ImageButton addUPCButton;
    private Fragment childFragment;
    private FragmentTransaction transaction;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_billing, container, false);
        cancelButton = view.findViewById(R.id.btn_cancel);
        proceedButton = view.findViewById(R.id.btn_proceed);
        fastForwardButton = view.findViewById(R.id.btn_fast_forward);
        discountAmtEdt = view.findViewById(R.id.discount_amt_et);
        discountPercentEdt = view.findViewById(R.id.discount_percent_et);
        camSwitch = view.findViewById(R.id.billing_cam_switch);
        frameLayout = view.findViewById(R.id.fragmentContainerForCameraBILLING);
        addUPCButton = view.findViewById(R.id.add_img_btn);
        addUPCEdt = view.findViewById(R.id.add_upc_edt);

        discountAmtEdt.setText("₹");
        Selection.setSelection(discountAmtEdt.getText(), discountAmtEdt.getText().length());


        discountAmtEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().startsWith("₹")) {
                    discountAmtEdt.setText("₹");
                    Selection.setSelection(discountAmtEdt.getText(), discountAmtEdt.getText().length());

                }

            }


        });

        discountPercentEdt.setText("%");
        Selection.setSelection(discountPercentEdt.getText(), discountPercentEdt.getText().length());


        discountPercentEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().endsWith("%")) {
                    discountPercentEdt.setText("%");
                    Selection.setSelection(discountPercentEdt.getText(), discountPercentEdt.getText().length());

                }

            }
        });


        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomerDetailsActivity.class);
                startActivity(intent);
            }
        });

        fastForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductSummaryActivity.class);
                startActivity(intent);
            }
        });

        //camera switch implementation

        camSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    frameLayout.setVisibility(View.VISIBLE);
                    addUPCEdt.setVisibility(View.INVISIBLE);
                    addUPCButton.setVisibility(View.INVISIBLE);

                    transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainerForCameraBILLING, childFragment).commit();
                } else {
                    transaction = getChildFragmentManager().beginTransaction();
                    transaction.remove(childFragment).commit();
                    frameLayout.setVisibility(View.INVISIBLE);
                    addUPCEdt.setVisibility(View.VISIBLE);
                    addUPCButton.setVisibility(View.VISIBLE);
                }
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.items_rv);


        List<Product> arrayList = new ArrayList<>();
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        adapter = new BillingRVAdapter(arrayList);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void messageFromChildToParent(String stringUPC, String stringRAW) {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        childFragment = new CameraFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerForCameraBILLING, childFragment).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }
}