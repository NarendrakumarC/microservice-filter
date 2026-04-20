package com.core.microservice_filter.dto;

public class FilteredProducts {

    private String BarCode;

    public FilteredProducts(String a) {
        BarCode=a;
    }

    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }


}
