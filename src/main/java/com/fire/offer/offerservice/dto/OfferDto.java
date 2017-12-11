package com.fire.offer.offerservice.dto;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OfferDto {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private Calendar uploadDate;
    private ArrayList uploadedFileNames;
    private  String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Calendar getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Calendar uploadDate) {
        this.uploadDate = uploadDate;
    }

    public ArrayList getUploadedFileNames() {
        return uploadedFileNames;
    }

    public void setUploadedFileNames(ArrayList uploadedFileNames) {
        this.uploadedFileNames = uploadedFileNames;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static class Validator {
        private  final OfferDto offerDto;
private List<String> errors = new ArrayList<>();

        private Validator(OfferDto offerDto) {
            this.offerDto = offerDto;
        }
        public boolean validate(){errors.clear();
        if (StringUtils.isEmpty(offerDto.title)){errors.add("The title cannot be empty");}
        if (StringUtils.isEmpty(offerDto.description)){errors.add("Description cannot be empty");}
        if (offerDto.price==0){errors.add("Please, enter price");}
        return errors.isEmpty();
        }
               public List<String> getErrors(){return errors;}
    }
}
