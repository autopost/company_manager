package com.example.company.controller;

import com.example.company.model.Company;
import com.example.company.model.Owner;
import com.example.company.repository.CompanyRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Log
@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createCompany(@Valid @RequestBody Company company) {
        log.info("Creating a new company...");
        //swagger???
        companyRepository.save(company);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Company>> getAllCompanies() {
        log.info("Get ALL companies...");
        return ResponseEntity.ok(companyRepository.findAll());
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Company> getCompanyDetails(@PathVariable Integer id) {
        log.info("Get company details...");
        Optional<Company> c = companyRepository.findById(id);
        if (c.isPresent()) {
            return new ResponseEntity(c.get(), HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void updateCompany(Company company) {
        log.info("Update company...");
        companyRepository.save(company);
    }

    @RequestMapping(value = "/owner",
            method = RequestMethod.GET, consumes = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void addOwner(Owner owner) {
        log.info("Add company owner...");

    }

    //TODO  check rest services, add owner support, IT, add react, readme, push to git, deploy
}