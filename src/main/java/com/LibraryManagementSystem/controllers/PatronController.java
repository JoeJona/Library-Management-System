package com.LibraryManagementSystem.controllers;

import com.LibraryManagementSystem.entity.Patron;
import com.LibraryManagementSystem.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PatronController {

    @Autowired
    PatronService patronService;

    @GetMapping("/patrons")
    public ResponseEntity<List<Patron>> getAllPatrons() {
        return new ResponseEntity<>(patronService.getAllPatrons(), HttpStatus.OK);
    }

    @GetMapping("/patrons/{patronId}")
    public ResponseEntity getPatron(@PathVariable("patronId") Long patronId) {
        if (patronService.isPatronExist(patronId)) {
            return new ResponseEntity(patronService.getPatron(patronId), HttpStatus.OK);
        }else {
            return new ResponseEntity("Patron Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patrons")
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
        return new ResponseEntity<>(patronService.addPatron(patron), HttpStatus.OK);
    }

    @PutMapping("/patrons/{patronId}")
    public ResponseEntity updatePatron(@PathVariable("patronId") Long patronId, @RequestBody Patron patron) {
        if (patronService.isPatronExist(patronId)) {
            return new ResponseEntity(patronService.updatePatron(patronId, patron), HttpStatus.OK);
        }else {
            return new ResponseEntity("Patron Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patrons/{patronId}")
    public ResponseEntity deletePatron(@PathVariable("patronId") Long patronId) {
        if (patronService.isPatronExist(patronId)) {
            patronService.deletePatron(patronId);
            return new ResponseEntity("patron deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity("Patron Not Found", HttpStatus.NOT_FOUND);
        }
    }

}
