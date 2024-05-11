package com.LibraryManagementSystem.entity;

//import javax.persistence.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PATRON")
@Data
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CONTACT_INFORMATION")
    private String contactInformation;
}
