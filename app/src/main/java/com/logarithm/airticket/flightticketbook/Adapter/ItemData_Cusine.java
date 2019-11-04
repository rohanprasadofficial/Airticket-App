package com.logarithm.airticket.flightticketbook.Adapter;

/**
 * Created by Wolf Soft on 2/1/2017.
 */

public class ItemData_Cusine {

    String text;
    int image;

    public ItemData_Cusine(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public ItemData_Cusine(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

