package com.example.fragmenttaskloaddata;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentOne extends Fragment {



    ListView listView;
    String[] names = {"Android", "Java","Kotlin","Data Science","Python","JavaScript","SQLite",".Net","HTML","CSS","BootStrap"};
    ArrayAdapter<String> arrayAdapter;

    public FragmentOne()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        view.setBackgroundColor(Color.WHITE);

        listView = view.findViewById(R.id.simple_List);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Bundle bundle = new Bundle();
               String tempListValue = arrayAdapter.getItem(position).toString();
               bundle.putString("key",tempListValue);
               FragmentTwo fragment = new FragmentTwo();
               fragment.setArguments(bundle);
               getFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();

            }
        });
        return view;
    }




}