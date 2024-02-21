package com.example.its_fyp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrainDataApiService {
    @GET("/api/getTrainData")
    Call<TrainDataResponse> getTrainData();
}