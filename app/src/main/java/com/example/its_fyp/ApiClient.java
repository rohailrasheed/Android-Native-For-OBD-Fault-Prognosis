package com.example.its_fyp;

public class ApiClient {
    private static final String BASE_URL = "https://obdapi.vercel.app";

    public static TrainDataApiService getTrainDataApiService() {
        return new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
                .create(TrainDataApiService.class);
    }
}