package com.example.hiddenhouston;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class Breakfast extends ListFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Desayuno));
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

}
