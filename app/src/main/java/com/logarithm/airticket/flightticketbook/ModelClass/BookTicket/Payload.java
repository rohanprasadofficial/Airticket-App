
package com.logarithm.airticket.flightticketbook.ModelClass.BookTicket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("From")
    @Expose
    private String from;
    @SerializedName("To")
    @Expose
    private String to;
    @SerializedName("DepartDate")
    @Expose
    private String departDate;
    @SerializedName("DestDate")
    @Expose
    private String destDate;
    @SerializedName("sourceTime")
    @Expose
    private String sourceTime;
    @SerializedName("destTime")
    @Expose
    private String destTime;
    @SerializedName("travelType")
    @Expose
    private String travelType;
    @SerializedName("passengerEmail")
    @Expose
    private String passengerEmail;
    @SerializedName("passengerName")
    @Expose
    private String passengerName;
    @SerializedName("flightId")
    @Expose
    private String flightId;
    @SerializedName("FlightNumber")
    @Expose
    private String flightNumber;
    @SerializedName("FlicketName")
    @Expose
    private String flicketName;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDestDate() {
        return destDate;
    }

    public void setDestDate(String destDate) {
        this.destDate = destDate;
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

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlicketName() {
        return flicketName;
    }

    public void setFlicketName(String flicketName) {
        this.flicketName = flicketName;
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
