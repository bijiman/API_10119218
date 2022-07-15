package com.biji.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class plane {
    @SerializedName("iata_code")
    @Expose
    private String iataCode;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icao_code")
    @Expose
    private String icaoCode;

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

}

