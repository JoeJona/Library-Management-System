package com.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "BOOKING_RECORD")
@Data
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PATRON_ID")
    private Patron patron;
    @Column(name = "BORROW_DATE")
    private LocalDate borrowDate;
    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;
}
