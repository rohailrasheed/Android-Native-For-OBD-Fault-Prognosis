package com.example.its_fyp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.its_fyp.ApiClient;
import com.example.its_fyp.R;
import com.example.its_fyp.TrainData;
import com.example.its_fyp.TrainDataApiService;
import com.example.its_fyp.TrainDataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiagnosticsFragment extends Fragment {

    Button btnAbs,btnExhaust,btnIgnition,btnCooling;
    TextView tvNothing;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diagnostics, container, false);

        tvNothing = view.findViewById(R.id.tv_nothing);
        btnAbs = view.findViewById(R.id.btnAbsfault);
        btnExhaust = view.findViewById(R.id.btnExhaustFault);
        btnIgnition = view.findViewById(R.id.btnIgnitionFault);
        btnCooling = view.findViewById(R.id.btnCoolantFault);

        TrainDataApiService apiService = ApiClient.getTrainDataApiService();
        apiService.getTrainData().enqueue(new Callback<TrainDataResponse>() {
            @Override
            public void onResponse(Call<TrainDataResponse> call, Response<TrainDataResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TrainDataResponse trainDataResponse = response.body();
                    if (trainDataResponse.getMessage().equals("true") && trainDataResponse.getData() != null && trainDataResponse.getData().length > 0) {
                        TrainData trainData = trainDataResponse.getTrainData();
                        System.out.println("Accuracy: " + trainData.getAccuracy());
                        System.out.println("Predict: " + trainData.getPredict());

                        int predict = trainData.getPredict();
//                        int predict = 4;
                        if (predict==0) {

                            btnAbs.setVisibility(View.GONE);
                            btnExhaust.setVisibility(View.GONE);
                            btnIgnition.setVisibility(View.GONE);
                            btnCooling.setVisibility(View.GONE);
                            tvNothing.setVisibility(View.VISIBLE);

                        } else if (predict==1) {

                            btnAbs.setVisibility(View.GONE);
                            btnExhaust.setVisibility(View.GONE);
                            btnIgnition.setVisibility(View.VISIBLE);
                            btnCooling.setVisibility(View.GONE);
                            tvNothing.setVisibility(View.GONE);

                        } else if (predict==2) {

                            btnAbs.setVisibility(View.VISIBLE);
                            btnExhaust.setVisibility(View.GONE);
                            btnIgnition.setVisibility(View.GONE);
                            btnCooling.setVisibility(View.GONE);
                            tvNothing.setVisibility(View.GONE);

                        } else if (predict==3) {
                            btnAbs.setVisibility(View.GONE);
                            btnExhaust.setVisibility(View.VISIBLE);
                            btnIgnition.setVisibility(View.GONE);
                            btnCooling.setVisibility(View.GONE);
                            tvNothing.setVisibility(View.GONE);

                        } else if (predict==4) {

                            btnAbs.setVisibility(View.GONE);
                            btnExhaust.setVisibility(View.GONE);
                            btnIgnition.setVisibility(View.GONE);
                            btnCooling.setVisibility(View.VISIBLE);
                            tvNothing.setVisibility(View.GONE);

                        }
                    } else {
                        System.out.println("Failed to get train data.");
                    }
                } else {
                    System.out.println("Failed to get train data. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TrainDataResponse> call, Throwable t) {
                System.out.println("Failed to get train data. Error: " + t.getMessage());
            }
        });

        return view;
    }


}