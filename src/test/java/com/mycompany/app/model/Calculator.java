package com.mycompany.app.model;

import java.util.Objects;

public class Calculator {
    private String numberOfInstances;
    private String operatingSystem;
    private String machineClass;
    private String series;
    private String machineType;
    private boolean addGPU;
    private String numberOfGPUs;
    private String GPUtype;
    private String localSSD;
    private String location;
    private String committedUsage;
    private Double estimation;

    public Calculator(
            String numberOfInstances,
            String operatingSystem,
            String machineClass,
            String series,
            String machineType,
            boolean addGPU,
            String numberOfGPUs,
            String GPUtype,
            String localSSD,
            String location,
            String committedUsage,
            Double estimation) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.addGPU = addGPU;
        this.numberOfGPUs = numberOfGPUs;
        this.GPUtype = GPUtype;
        this.localSSD = localSSD;
        this.location = location;
        this.committedUsage = committedUsage;
        this.estimation = estimation;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public boolean getAddGPU() {
        return addGPU;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGPUtype() {
        return GPUtype;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getLocation() {
        return location;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public Double getEstimation() {
        return estimation;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances: ' " + numberOfInstances + '\'' +
                ", OS: '" + operatingSystem + '\'' +
                ", machine class: '" + machineClass + '\'' +
                ", series: '" + series + '\'' +
                ", machine type : '" + machineType + '\'' +
                ", addGPU: '" + addGPU +
                ", numberOfGPUs: '" + numberOfGPUs +
                ", GPUtype: '" + GPUtype +
                ", localSSD: '" + localSSD +
                ", location: '" + location +
                ", committedUsage: '" + committedUsage +
                ", estimation: '" + estimation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Calculator that = (Calculator) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(addGPU, that.addGPU) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(GPUtype, that.GPUtype) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(location, that.location) &&
                Objects.equals(committedUsage, that.committedUsage) &&
                Objects.equals(estimation, that.estimation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, machineClass, series, machineType, addGPU, numberOfGPUs,
                GPUtype, localSSD, location, committedUsage, estimation);
    }
}
