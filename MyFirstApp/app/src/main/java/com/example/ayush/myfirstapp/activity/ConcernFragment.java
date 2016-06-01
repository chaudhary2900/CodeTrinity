package com.example.ayush.myfirstapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ayush.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayush on 27/5/16.
 */
public class ConcernFragment extends Fragment {

        Spinner spinner;
        View view;
public ConcernFragment() {
        // Required empty public constructor
        }

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


     //spinner=(Spinner)view.findViewById(R.id.spinner_subcategory1);

        // Spinner Drop down elements
       // List<String> categories = new ArrayList<String>();
       // categories.add("Automobile");
       // categories.add("Business Services");
      //  categories.add("Computers");
       // categories.add("Education");
       // categories.add("Personal");
       // categories.add("Travel");


     //   ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
      //  dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_concern, container, false);


        // Inflate the layout for this fragment
        return rootView;
        }

@Override
public void onAttach(Activity activity) {
        super.onAttach(activity);
        }

@Override
public void onDetach() {
        super.onDetach();
        }
        }