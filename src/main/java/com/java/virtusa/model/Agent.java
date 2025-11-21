package com.java.virtusa.model;

import java.math.BigDecimal;

public class Agent {
    private String agentID;
    private String name;
    private String city;
    private Gender gender;
    private int maritalStatus; // 0 or 1 assumed
    private BigDecimal premium;

    public Agent() {}

    public Agent(String agentID, String name, String city, Gender gender, int maritalStatus, BigDecimal premium) {
        this.agentID = agentID;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.premium = premium;
    }

    public String getAgentID() { return agentID; }
    public void setAgentID(String agentID) { this.agentID = agentID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public int getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(int maritalStatus) { this.maritalStatus = maritalStatus; }

    public BigDecimal getPremium() { return premium; }
    public void setPremium(BigDecimal premium) { this.premium = premium; }

    @Override
    public String toString() {
        return "Agent{" +
                "agentID='" + agentID + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", maritalStatus=" + maritalStatus +
                ", premium=" + premium +
                '}';
    }
}
