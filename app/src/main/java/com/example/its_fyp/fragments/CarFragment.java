package com.example.its_fyp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.its_fyp.R;
import com.example.its_fyp.adapters.MyCarAdapter;
import com.example.its_fyp.models.MyCar;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class CarFragment extends Fragment {
    private ArrayList<MyCar> myCars;
    RecyclerView recyclerView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        this.myCars = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_my_cars);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.recyclerView.setHasFixedSize(true);
        MyCarAdapter myCarAdapter = new MyCarAdapter(requireContext(), this.myCars);
        this.recyclerView.setAdapter(myCarAdapter);
        populateDummyData();
        return view;
    }

    private void populateDummyData() {
        MyCar myCar = new MyCar(R.drawable.logo, "2022", "Toyota,Fortuner", "Other");
        MyCar myCar1 = new MyCar(R.drawable.logo, "2020", "Toyota,Corolla", "Electric");
        MyCar myCar2 = new MyCar(R.drawable.logo, "2021", "Toyota,Hilux", "Gasoline");
        this.myCars.add(myCar);
        this.myCars.add(myCar1);
        this.myCars.add(myCar2);
    }
}