package com.logarithm.airticket.flightticketbook.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecyclerMessage {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("flightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("flightID")
    @Expose
    private String flightID;
    @SerializedName("Source")
    @Expose
    private String source;
    @SerializedName("Destination")
    @Expose
    private String destination;
    @SerializedName("sourceTime")
    @Expose
    private String sourceTime;
    @SerializedName("destTime")
    @Expose
    private String destTime;
    @SerializedName("sourceDate")
    @Expose
    private String sourceDate;
    @SerializedName("DestDate")
    @Expose
    private String destDate;
    @SerializedName("FclassPrice")
    @Expose
    private String fclassPrice;
    @SerializedName("BclassPrice")
    @Expose
    private String bclassPrice;
    @SerializedName("PclassPrice")
    @Expose
    private String pclassPrice;
    @SerializedName("EclassPrice")
    @Expose
    private String eclassPrice;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("__v")
    @Expose
    private Integer v;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSourceTime() {
        return sourceTime;
    }

    public void setSourceTime(String sourceTime) {
        this.sourceTime = sourceTime;
    }

    public String getDestTime() {
        return destTime;
    }

    public void setDestTime(String destTime) {
        this.destTime = destTime;
    }

    public String getSourceDate() {
        return sourceDate;
    }

    public void setSourceDate(String sourceDate) {
        this.sourceDate = sourceDate;
    }

    public String getDestDate() {
        return destDate;
    }

    public void setDestDate(String destDate) {
        this.destDate = destDate;
    }

    public String getFclassPrice() {
        return fclassPrice;
    }

    public void setFclassPrice(String fclassPrice) {
        this.fclassPrice = fclassPrice;
    }

    public String getBclassPrice() {
        return bclassPrice;
    }

    public void setBclassPrice(String bclassPrice) {
        this.bclassPrice = bclassPrice;
    }

    public String getPclassPrice() {
        return pclassPrice;
    }

    public void setPclassPrice(String pclassPrice) {
        this.pclassPrice = pclassPrice;
    }

    public String getEclassPrice() {
        return eclassPrice;
    }

    public void setEclassPrice(String eclassPrice) {
        this.eclassPrice = eclassPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}