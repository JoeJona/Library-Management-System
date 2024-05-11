package com.LibraryManagementSystem.services.impl;

import com.LibraryManagementSystem.entity.Patron;
import com.LibraryManagementSystem.repo.PatronRepo;
import com.LibraryManagementSystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    PatronRepo patronRepo;

    @Override
    public boolean isPatronExist(Long patronId) {
        return patronRepo.findById(patronId).isPresent();
    }

    @Override
    public List<Patron> getAllPatrons() {
        return (List<Patron>) patronRepo.findAll();
    }

    @Override
    public Patron getPatron(Long patronId) {
        return patronRepo.getPatronById(patronId);
    }

    @Override
    public Patron addPatron(Patron patron) {
        Patron newPatron = new Patron();
        newPatron.setName(patron.getName());
        newPatron.setContactInformation(patron.getContactInformation());
        patronRepo.save(newPatron);
        return newPatron;
    }

    @Override
    public Patron updatePatron(Long patronId, Patron patron) {
        Patron updatedPatron = patronRepo.getPatronById(patronId);
        updatedPatron.setName(patron.getName());
        updatedPatron.setContactInformation(patron.getContactInformation());
        patronRepo.save(updatedPatron);
        return updatedPatron;
    }

    @Override
    public void deletePatron(Long patronId) {
        patronRepo.deleteById(patronId);
    }

}
