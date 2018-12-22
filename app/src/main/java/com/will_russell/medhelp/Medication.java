package com.will_russell.medhelp;

import java.util.ArrayList;

public class Medication {
    private String name;
    private int totalTimesTaken;
    private int[] timesTaken;
    private Integer length; // prescription period
    // Either or, not both
    private Double doseSize;
    private Integer tabletTotal; // How many 
    private String[] requirements; // What needs to be taken with the medication

    public static ArrayList<Medication> medicationList = new ArrayList<Medication>();

    public Medication(String name, int totalTimesTaken, Double doseSize, int length) {
        this.name = name;
        this.totalTimesTaken = totalTimesTaken;
        this.doseSize = doseSize;
        this.length = length;
    }

    // Constructor for when medication is until otherwise stated
    public Medication(String name, int totalTimesTaken, Double doseSize) {
        this.name = name;
        this.totalTimesTaken = totalTimesTaken;
        this.doseSize = doseSize;
    }

    public Medication(String name, int totalTimesTaken, Integer tabletTotal) {
        this.name = name;
        this.totalTimesTaken = totalTimesTaken;
        this.tabletTotal = tabletTotal;
    }

    public String getName() {
        return this.name;
    }
    public int[] getTimesTaken() {
        return this.timesTaken;
    }
    public int getTotalTimesTaken() {
        return this.totalTimesTaken;
    }
    public Double getDoseSize() {
        return this.doseSize;
    }
    public Integer getLength() {
        return this.length;
    }
    public Integer gettabletTotal() {
        return this.tabletTotal;
    }
    public String[] getRequirements() {
        return this.requirements;
    }

    public void setName(String name) {
        this.name= name;
    }
    public void setTimesTaken(int[] times) { // Array be set to another???
        for (int i = 0; i < times.length; i++) {
            this.timesTaken[i] = times[i];
        }
    }
    public void setTotalTimesTaken(int totalTimesTaken) {
        this.totalTimesTaken = totalTimesTaken;
    }
    public void setDoseSize(Double dose) {
        this.doseSize = dose;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public void settabletTotal(Integer tabletTotal) {
        this.tabletTotal = tabletTotal;
    }

    public void setRequirements(String[] requirements) {
        for (int i = 0; i < requirements.length; i++) {
            this.requirements[i] = requirements[i];
        }
    }

    public boolean validtabletTotal() {
        if (this.tabletTotal != null) {
            return true;
        } else {
            return false;
        }
    }
}
