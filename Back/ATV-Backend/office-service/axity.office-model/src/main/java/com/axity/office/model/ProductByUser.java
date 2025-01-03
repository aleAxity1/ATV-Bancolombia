package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ATVFFUSP")
@Getter
@Setter
public class ProductByUser {

    @Id
    @Column(name = "XPUSER", length = 10, nullable = false)
    private String xpuser;

    @Column(name = "XPCOPR", length = 2, nullable = false)
    private String xpcopr;
}