package com.fire.offer.offerservice.model;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
public class OfferCreator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private double price;
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
}
