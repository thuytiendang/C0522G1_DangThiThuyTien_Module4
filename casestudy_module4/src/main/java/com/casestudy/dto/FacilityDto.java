package com.casestudy.dto;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.facility.Facility;
import com.casestudy.model.facility.FacilityType;
import com.casestudy.model.facility.RentType;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

interface First1 {
}

interface Second1 {
}

@GroupSequence(value = {FacilityDto.class, First1.class, Second1.class})
public class FacilityDto {
    private int facilityId;

    @NotBlank(groups = First1.class)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Invalid format (not include number, first character must lowercase)", groups = Second1.class)
    private String facilityName;

    @NotBlank(groups = First1.class)
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Area must be greater than 0.", groups = Second1.class)
    private String facilityArea;

    @NotBlank(groups = First1.class)
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Price must be greater than 0.", groups = Second1.class)
    private String facilityCost;

    @NotBlank(groups = First1.class)
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "People must be greater than 0.", groups = Second1.class)
    private String maxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "People must be greater than 0.", groups = First1.class)
    private String poolArea;

    @Pattern(regexp = "^[1-9]\\d*| *$", message = "People must be greater than 0.", groups = First1.class)
    private String numberOfFloors;

    private String facilityFree;

    private boolean isDelete;
    private Set<Contract> contracts;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDto() {
    }

    public FacilityDto(int facilityId, String facilityName, String facilityArea, String facilityCost, String maxPeople,
                       String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors,
                       String facilityFree, boolean isDelete, Set<Contract> contracts, FacilityType facilityType,
                       RentType rentType) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityArea = facilityArea;
        this.facilityCost = facilityCost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.isDelete = isDelete;
        this.contracts = contracts;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(String facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(String facilityCost) {
        this.facilityCost = facilityCost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
