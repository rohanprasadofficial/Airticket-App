package com.logarithm.airticket.flightticketbook.ParametersClass;

public class Register {
    private String email;
    private String password;
    private String name;

    public Register(String id, String password,String name) {
        this.email = id;
        this.password = password;
        this.name = name;
    }
}