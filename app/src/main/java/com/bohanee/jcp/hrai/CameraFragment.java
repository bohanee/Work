package com.bohanee.jcp.hrai;
//CAMERAFRAGMENT
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class CameraFragment extends Fragment {
    private CodeScanner mCodeScanner;
    private TextView editText;
    private OnChildFragmentInteractionListener mParentListener;
    String url ="https://upcdatabase.com/item/";
    public String URL, UPC;

    public interface OnChildFragmentInteractionListener {
        void messageFromChildToParent(String stringUPC, String stringRAW);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_camera, container, false);
        final Activity activity = getActivity();
        editText = v.findViewById(R.id.HiddenText);
        CodeScannerView scannerView = v.findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(activity, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        UPC = result.getText().toString();
                        Log.v("Dez1","= "+UPC+"");
                        URL = url + UPC;
                        Log.v("Dez2","= "+URL+"");
                        new JSoupInBackground().execute();
                        Log.v("Dez7","Continue");
                        mCodeScanner.startPreview();
                    }
                });
            }
        });
        return v;
    }

    //JSoup
    public class JSoupInBackground extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(URL).timeout(30 * 1000).get();
                Element element = document.select("table").first();
                for (Element tr : element.select("tr")) {
                    int i = 0;
                    for (Element td : element.select("td")) {
                        if (td.text().equals("Description")) {
                            i = 98;
                        }
                        if (i == 100) {
                            Log.v("Dez3"," -> "+td.text()+","+UPC+"");//DoneInBackground
                            mParentListener.messageFromChildToParent(td.text().toString()+"",UPC+"");
                            Log.v("Dez6"," Changed to C ");
                            break;
                        }
                        i = i + 1;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.v("DezERROR",""+e+"");//DoneInBackground
                Toast.makeText(getContext(),e+"",Toast.LENGTH_SHORT).show();
                //mParentListener.messageFromChildToParent(URL);
            }
            //mCodeScanner.startPreview();
            return null;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // check if parent Fragment implements listener
        if (getParentFragment() instanceof OnChildFragmentInteractionListener) {
            mParentListener = (OnChildFragmentInteractionListener) getParentFragment();
        } else {
            throw new RuntimeException("The parent fragment must implement OnChildFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mParentListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}