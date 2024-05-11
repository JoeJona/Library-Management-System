package com.LibraryManagementSystem.repo;

import com.LibraryManagementSystem.entity.Patron;
import org.springframework.data.repository.CrudRepository;

public interface PatronRepo extends CrudRepository<Patron, Long> {

    Patron getPatronById(Long patronId);

}
