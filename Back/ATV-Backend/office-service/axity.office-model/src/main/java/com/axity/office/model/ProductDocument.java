package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ATVFFPDO")
public class ProductDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "XPCOPDO")
    private Long xpcopdo;

    @Column(name = "XPCOPR", length = 2, nullable = false)
    private String xpcopr;

    @Column(name = "XPCODO", length = 3, nullable = false)
    private String xpcodo;

    @Column(name = "XPDSDO", length = 25)
    private String xpdsdo;

    @Column(name = "XPCTA")
    private Long xpcta;

    @Column(name = "XPSTDO", length = 1)
    private String xpstdo;

    @Column(name = "XPFECA", length = 1)
    private String xpfeca;
}