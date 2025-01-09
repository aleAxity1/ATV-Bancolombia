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
@Table(name = "ATVFFFRE")
@Getter
@Setter
public class Frequency implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FXID", nullable = false)
    private Long fxid;

    @Column(name = "FXCOPR", nullable = false, length = 2)
    private String fxcopr;

    @Column(name = "FXCODO", nullable = false, length = 3)
    private String fxcodo;

    @Column(name = "FXFRAR", nullable = false, length = 1)
    private String fxfrar;

    @Column(name = "FXDIFR", nullable = false, precision = 3, scale = 0)
    private Integer fxdifr;
}