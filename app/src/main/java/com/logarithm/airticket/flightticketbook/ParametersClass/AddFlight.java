package com.logarithm.airticket.flightticketbook.ParametersClass;


public class AddFlight {
    private String name;
    private String flightNumber;
    private String flightID;
    private String Source;
    private String Destination;
    private String sourceTime;
    private String destTime;
    private String sourceDate;
    private String DestDate;
    private String FclassPrice;
    private String BclassPrice;
    private String PclassPrice;
    private String EclassPrice;


    public AddFlight(String id, String password,String flightID,String Source,String Destination,String sourceTime,String destTime,String sourceDate,String DestDate,String FclassPrice,String BclassPrice,String PclassPrice,String EclassPrice) {
        this.name = id;
        this.flightNumber = password;
        this.flightID = flightID;
        this.Source = Source;
        this.Destination = Destination;
        this.sourceTime = sourceTime;
        this.destTime = destTime;
        this.sourceDate = sourceDate;
        this.DestDate = DestDate;
        this.FclassPrice = FclassPrice;
        this.BclassPrice = BclassPrice;
        this.PclassPrice = PclassPrice;
        this.EclassPrice = EclassPrice;


    }
}