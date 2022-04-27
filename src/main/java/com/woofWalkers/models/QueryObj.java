package com.woofWalkers.models;

// QueryObj model for custom queries
public class QueryObj {
    private String queryName = "";

    private String queryAppointmentDate;

    private String queryCity = "";

    // getters and setters for custom queries
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
