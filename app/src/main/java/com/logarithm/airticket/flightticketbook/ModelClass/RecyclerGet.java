package com.logarithm.airticket.flightticketbook.ModelClass;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecyclerGet {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private List<RecyclerMessage> message = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<RecyclerMessage> getMessage() {
        return message;
    }


    public void setMessage(List<RecyclerMessage> message) {
        this.message = message;
    }

}