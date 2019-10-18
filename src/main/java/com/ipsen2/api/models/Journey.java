package com.ipsen2.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model containing data about a certain journey.
 *
 * @author TimvHal, Tim W
 * @version 14/10/2019
 */
public class Journey {

    @JsonProperty("journeyId")
    private String journeyId;
    @JsonProperty("kilometers")
    private int kilometers;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("description")
    private String description;
    @JsonProperty("date")
    private String date;
    @JsonProperty("licensePlate")
    private String licensePlate;
    @JsonProperty("isBilled")
    private boolean isBilled;
    @JsonProperty("parkingCost")
    private double parkingCost;
    @JsonProperty("otherCost")
    private double otherCost;
    @JsonProperty("rate")
    private double rate;
    @JsonProperty("projectId")
    private String projectId;
    @JsonProperty("creatorId")
    private String creatorId;

    public Journey(String journeyId, int kilometers, String destination, String description, String date, String licensePlate, boolean isBilled, double parkingCost, double otherCost, double rate, String projectId, String creatorId) {

        this.journeyId = journeyId;
        this.kilometers = kilometers;
        this.destination = destination;
        this.description = description;
        this.date = date;
        this.licensePlate = licensePlate;
        this.isBilled = isBilled;
        this.parkingCost = parkingCost;
        this.otherCost = otherCost;
        this.rate = rate;
        this.projectId = projectId;
        this.creatorId = creatorId;

    }

    public String getJourneyId() {
        return journeyId;
    }

    public int getKilometers() {
        return kilometers;
    }

    public String getDestination() {
        return destination;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isBilled() {
        return isBilled;
    }

    public double getParkingCost() {
        return parkingCost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public double getRate() {
        return rate;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getCreatorId() {
        return creatorId;
    }
}