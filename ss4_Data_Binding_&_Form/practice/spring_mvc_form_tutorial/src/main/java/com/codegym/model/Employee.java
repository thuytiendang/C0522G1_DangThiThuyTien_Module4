package com.codegym.model;

public class Employee {
    private String id;
    private String name;
    private String contractNumber;

    public Employee() {
    }

    public Employee(String id, String name, String contractNumber) {
        this.id = id;
        this.name = name;
        this.contractNumber = contractNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
}
