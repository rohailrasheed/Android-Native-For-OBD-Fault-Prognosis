package com.example.its_fyp;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TrainDataResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private String[] data;

    public String getMessage() {
        return message;
    }

    public String[] getData() {
        return data;
    }

    // Method to parse the inner JSON string and return TrainData object
    public TrainData getTrainData() {
        Gson gson = new Gson();
        TrainData trainData = gson.fromJson(data[0], TrainData.class);
        return trainData;
    }
}