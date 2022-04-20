package com.woofWalkers.models;

public class QueryObj {
    private String queryName = "";

    private String queryAppointmentDate;

    private String queryCity = "";

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQueryAppointmentDate() {
        return queryAppointmentDate;
    }

    public void setQueryAppointmentDate(String queryAppointmentDate) {
        this.queryAppointmentDate = queryAppointmentDate;
    }

    public String getQueryCity() {
        return queryCity;
    }

    public void setQueryCity(String queryCity) {
        this.queryCity = queryCity;
    }
}
