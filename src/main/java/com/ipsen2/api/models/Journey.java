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
    private int journeyId;
    @JsonProperty("kilometers")
    private int kilometers;
    @JsonProperty("vehicleLicensePlate")
    private String vehicleLicensePlate;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("rateId")
    private int rateId;
    @JsonProperty("projectId")
    private int projectId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("parkingCost")
    private double parkingCost;
    @JsonProperty("otherCost")
    private double otherCost;
    @JsonProperty("creatorId")
    private int creatorId;
    @JsonProperty("isBilled")
    private boolean isBilled;

    public Journey(int id, int km, String vLicensePlate, String dest, int rate, int project, String desc,
                   double parkingCost, double extraCost, int creatorId, boolean isBilled) {

        this.journeyId = id;
        this.kilometers = km;
        this.vehicleLicensePlate = vLicensePlate;
        this.destination = dest;
        this.rateId = rate;
        this.projectId = project;
        this.description = desc;
        this.parkingCost = parkingCost;
        this.otherCost = extraCost;
        this.creatorId = creatorId;
        this.isBilled = isBilled;

    }

}