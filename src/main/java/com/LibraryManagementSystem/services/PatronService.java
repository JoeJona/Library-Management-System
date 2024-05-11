package com.LibraryManagementSystem.services;

import com.LibraryManagementSystem.entity.Patron;

import java.util.List;

public interface PatronService {

    boolean isPatronExist(Long patronId);
    List<Patron> getAllPatrons();
    Patron getPatron(Long patronId);
    Patron addPatron(Patron patron);
    Patron updatePatron(Long patronId, Patron patron);
    void deletePatron(Long patronId);

}
