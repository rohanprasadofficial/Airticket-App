
package com.logarithm.airticket.flightticketbook.ModelClass.BookTicket;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookTicket {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("payload")
    @Expose
    private Payload payload;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}
