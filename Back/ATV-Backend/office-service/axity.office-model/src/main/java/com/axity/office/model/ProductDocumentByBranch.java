package com.axity.office.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ATVFFPDS")
@Getter
@Setter
public class ProductDocumentByBranch implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "XSID", nullable = false)
    private Long xsid;

    @Column(name = "XSCOSU", nullable = false)
    private Short xscosu;

    @Column(name = "XSCOPR", nullable = false, length = 2)
    private String xscopr;

    @Column(name = "XSCODO", nullable = false, length = 3)
    private String xscodo;
}