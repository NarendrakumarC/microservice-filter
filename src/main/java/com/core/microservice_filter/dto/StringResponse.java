package com.core.microservice_filter.dto;

public class StringResponse {
    private String echo;

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public StringResponse(String s) {
        this.echo = s;
    }

    public String getEcho() {
        return echo;
    }


}
