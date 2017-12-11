package com.fire.offer.offerservice.controller;

import com.fire.offer.offerservice.dao.OfferDao;
import com.fire.offer.offerservice.dto.OfferDto;
import com.fire.offer.offerservice.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Controller
@RequestMapping("/employee")
public class OfferController {
    @Autowired
    private OfferDao offerDao;

        @RequestMapping("")
    public String getAll(Pageable pageable, Model model) {
        model.addAttribute("page", offerDao.getAll(pageable));
        return "offers";
    }

    @RequestMapping("/{id}/edit")
    public String editOffer(@PathVariable("id") Integer id, Model model) {
        Offer offer = offerDao.getOne(id);
        return goToEdit(offer, model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void editOffer(@PathVariable("id") Integer id) {
        Offer offer = offerDao.getOne(id);
        offerDao.delete(offer);
    }

    @RequestMapping("/edit")
    public String createOffer(Model model) {
        Offer offer = new Offer();
        return goToEdit(offer, model);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveOffer(@RequestBody OfferDto offerDto, Model model, HttpServletResponse response) {

        Offer offer = (offerDto.getId() != null && offerDto.getId() != 0)
                ? offerDao.getOne(offerDto.getId()) : new Offer();

        offer.setTitle(offerDto.getTitle());
        offer.setDescription(offerDto.getDescription());
        offer.setLocation(offerDto.getLocation());
        offer.setPrice(offerDto.getPrice());
        offer.setUploadDate(toString(Calendar.getInstance()));

        EmployeeDto.Validator validator = EmployeeDto.validator(employeeDto);
        if (!validator.validate()) {
            model.addAttribute("errors", validator.getErrors());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            if (employee.getId() != 0) {
                employeeDao.update(employee);
            } else {
                employeeDao.create(employee);
            }
        }

        return goToEdit(offer, model);
    }

    private String goToEdit(Offer offer, Model model) {
        model.addAttribute("offer", offer);
                return "edit";
    }
}
