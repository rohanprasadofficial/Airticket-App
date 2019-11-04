package com.logarithm.airticket.flightticketbook.ModelClass;

/**
 * Created by KURPC on 03-02-2018.
 */

public class Flight {

    private String txtFlightName;
    private String txtCountry;
    private String txtStationArrived;
    private int imgPlane;
    private String txtCountryDestination;
    private String txtStationDestination;
    private String btnBuy;

    public String getTxtFlightName() {
        return txtFlightName;
    }

    public void setTxtFlightName(String txtFlightName) {
        this.txtFlightName = txtFlightName;
    }

    public String getTxtCountry() {
        return txtCountry;
    }

    public void setTxtCountry(String txtCountry) {
        this.txtCountry = txtCountry;
    }

    public String getTxtStationArrived() {
        return txtStationArrived;
    }

    public void setTxtStationArrived(String txtStationArrived) {
        this.txtStationArrived = txtStationArrived;
    }

    public int getImgPlane() {
        return imgPlane;
    }

    public void setImgPlane(int imgPlane) {
        this.imgPlane = imgPlane;
    }

    public String getTxtCountryDestination() {
        return txtCountryDestination;
    }

    public void setTxtCountryDestination(String txtCountryDestination) {
        this.txtCountryDestination = txtCountryDestination;
    }

    public String getTxtStationDestination() {
        return txtStationDestination;
    }

    public void setTxtStationDestination(String txtStationDestination) {
        this.txtStationDestination = txtStationDestination;
    }

    public String getBtnBuy() {
        return btnBuy;
    }

    public void setBtnBuy(String btnBuy) {
        this.btnBuy = btnBuy;
    }

    public Flight(String txtFlightName, String txtCountry, String txtStationArrived, int imgPlane, String txtCountryDestination, String txtStationDestination, String btnBuy) {
        this.txtFlightName = txtFlightName;
        this.txtCountry = txtCountry;
        this.txtStationArrived = txtStationArrived;
        this.imgPlane = imgPlane;
        this.txtCountryDestination = txtCountryDestination;
        this.txtStationDestination = txtStationDestination;
        this.btnBuy = btnBuy;


    }
}
