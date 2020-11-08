package org.sashaworms.pvt.service;

public class Department {
    private Integer DepId;
    private String DepName;

    public Department() {
    }

    public Department(Integer depId, String depName) {
        DepId = depId;
        DepName = depName;
    }

    public Integer getDepId() {
        return DepId;
    }

    public void setDepId(Integer depId) {
        DepId = depId;
    }

    public String getDepName() {
        return DepName;
    }

    public void setDepName(String depName) {
        DepName = depName;
    }
}
