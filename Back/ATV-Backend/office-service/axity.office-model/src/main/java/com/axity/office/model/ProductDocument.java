package com.axity.office.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ATVFFPDO")
public class ProductDocument {

    @Id
    @Column(name = "XPID", nullable = false)
    private Long xpid;

    @Column(name = "XPCOPR", nullable = false, length = 2)
    private String xpcopr;

    @Column(name = "XPCODO", nullable = false, length = 3)
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