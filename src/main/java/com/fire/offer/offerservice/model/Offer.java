package com.fire.offer.offerservice.model;

import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.*;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;
    private Double price;
    private Calendar uploadDate;
    private ArrayList uploadedFileNames;

    @ManyToOne
    private  String location;


    public String getTitle(int id) {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription(int id) {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation(int id) {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice(int id) {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList getUploadedFileNames(int id) {
        return uploadedFileNames;
    }

    public void setUploadedFileNames(ArrayList listUploadedFiles) {
        this.uploadedFileNames = listUploadedFiles;
    }

    public Calendar getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate() {
        Calendar cal = Calendar.getInstance();
                this.uploadDate = cal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
