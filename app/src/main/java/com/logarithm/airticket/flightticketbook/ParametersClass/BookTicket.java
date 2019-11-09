package com.logarithm.airticket.flightticketbook.ParametersClass;


public class BookTicket {
    private String From;
    private String To;
    private String DepartDate;
    private String DestDate;
    private String sourceTime;
    private String destTime;
    private String travelType;
    private String email;
    private String name;
    private String flightId;
    private String FlightNumber;
    private String FlicketName;


    public BookTicket(String From, String To,String DepartDate,String DestDate,String sourceTime,String destTime,String travelType,String email,String name,String flightId,String FlightNumber,String FlicketName) {
        this.From = From;
        this.To = To;
        this.DepartDate = DepartDate;
        this.DestDate = DestDate;
        this.sourceTime = sourceTime;
        this.destTime = destTime;
        this.sourceTime = sourceTime;
        this.destTime = destTime;
        this.travelType = travelType;
        this.email = email;
        this.name = name;
        this.flightId = flightId;
        this.FlightNumber = FlightNumber;
        this.FlicketName = FlicketName;


    }
}