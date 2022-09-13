package com.medicalDeclaration.model;

public class MedicalDeclaration {
   private String name;
   private String dateOfBirth;
   private String gender;
   private String country;
   private String idCard;
   private String vehicle;
   private String vehiclePLate;
   private int numberOfSeat;
   private String startDate;
   private String endDate;
   private String addressTravel;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, String dateOfBirth, String gender, String country, String idCard, String vehicle,
                              String vehiclePLate, int numberOfSeat, String startDate, String endDate, String addressTravel) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehiclePLate = vehiclePLate;
        this.numberOfSeat = numberOfSeat;
        this.startDate = startDate;
        this.endDate = endDate;
        this.addressTravel = addressTravel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehiclePLate() {
        return vehiclePLate;
    }

    public void setVehiclePLate(String vehiclePLate) {
        this.vehiclePLate = vehiclePLate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAddressTravel() {
        return addressTravel;
    }

    public void setAddressTravel(String addressTravel) {
        this.addressTravel = addressTravel;
    }
}
