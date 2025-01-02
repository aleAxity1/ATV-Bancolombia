package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ATVFFPDO")
public class ProductDocument {

    @Id
    @Column(name = "XPCOPR", length = 2, nullable = false)
    private String xpcopr;

    @Id
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