package com.example.its_fyp.models;

/* loaded from: classes3.dex */
public class MyCar {
    private String carName;
    private String genre;
    private int logo;
    private String modelNo;

    public MyCar(int logo, String modelNo, String carName, String genre) {
        this.logo = logo;
        this.modelNo = modelNo;
        this.carName = carName;
        this.genre = genre;
    }

    public int getLogo() {
        return this.logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getModelNo() {
        return this.modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getCarName() {
        return this.carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}