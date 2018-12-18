package com.will_russell.medhelp;

import java.util.ArrayList;

public class Medication {
    private String name;
    private int timesTaken;
    private int length;
    // Either or, not both
    private Double doseSize;
    private Integer quantity;

    public static ArrayList<Medication> medicationList = new ArrayList<Medication>();

    public Medication(String name, int timesTaken, Double doseSize, int length) {
        this.name = name;
        this.timesTaken = timesTaken;
        this.doseSize = doseSize;
        this.length = length;
    }

    // Constructor for when medication is until otherwise stated
    public Medication(String name, int timesTaken, Double doseSize) {
        this.name = name;
        this.timesTaken = timesTaken;
        this.doseSize = doseSize;
    }

    public Medication(String name, int timesTaken, Integer quantity) {
        this.name = name;
        this.timesTaken = timesTaken;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    public int getTimesTaken() {
        return this.timesTaken;
    }
    public Double getDoseSize() {
        return this.doseSize;
    }
    public int getLength() {
        return this.length;
    }
    public Integer getQuantity() {
        return this.quantity;
    }


    public void setName(String name) {
        this.name= name;
    }
    public void setTimesTaken(int timesTaken) {
        this.timesTaken = timesTaken;
    }
    public void setDoseSize(Double dose) {
        this.doseSize = dose;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean validQuantity() {
        if (this.quantity != null) {
            return true;
        } else {
            return false;
        }
    }
}
