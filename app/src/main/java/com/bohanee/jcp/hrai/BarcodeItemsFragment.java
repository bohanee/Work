package com.bohanee.jcp.hrai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class BarcodeItemsFragment extends Fragment implements CameraFragment.OnChildFragmentInteractionListener {

    private OnFragmentInteractionListener MListener;
    FragmentTransaction fragmentTransactionB;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_barcode_items, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.barcode_rv);
        Button button= view.findViewById(R.id.barcode_add_btn);
        camSwitch = view.findViewById(R.id.barcode_cam_switch);
        frameLayout = view.findViewById(R.id.fragmentContainerForCameraBARCODE);
        addUPCButton = view.findViewById(R.id.bar_add_img_btn);
        addUPCEdt = view.findViewById(R.id.bar_add_upc_edt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Tempo. data
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        productList.add(new Product("Mfdjfk", 40, 60, 5));
        productList.add(new Product("Dkfjsd", 70, 90, 15));
        productList.add(new Product("Fdlkjfd", 30, 60, 8));
        BarcodeAdapter barcodeAdapter = new BarcodeAdapter(productList);
        recyclerView.setAdapter(barcodeAdapter);

        //camera switch implementation

        camSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    frameLayout.setVisibility(View.VISIBLE);
                    addUPCEdt.setVisibility(View.INVISIBLE);
                    addUPCButton.setVisibility(View.INVISIBLE);

                    transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainerForCameraBARCODE, childFragment).commit();
                } else {
                    transaction = getChildFragmentManager().beginTransaction();
                    transaction.remove(childFragment).commit();
                    frameLayout.setVisibility(View.INVISIBLE);
                    addUPCEdt.setVisibility(View.VISIBLE);
                    addUPCButton.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }

    @Override
    public void messageFromChildToParent(String stringUPC, String stringRAW) {

    }

    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        childFragment = new CameraFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerForCameraBARCODE, childFragment).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MListener = null;
    }
}