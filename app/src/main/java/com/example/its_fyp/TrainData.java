package com.example.its_fyp;

import com.google.gson.annotations.SerializedName;

public class TrainData {
    @SerializedName("accuracy")
    private double accuracy;

    @SerializedName("predict")
    private int predict;

    public double getAccuracy() {
        return accuracy;
    }

    public int getPredict() {
        return predict;
    }
}