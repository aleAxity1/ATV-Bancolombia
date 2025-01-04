package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ATVFFUSP", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"XPUSER", "XPCOPR"})
})
@Getter
@Setter
public class ProductByUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "XPID")
    private Long xpid;

    @Column(name = "XPUSER", length = 10, nullable = false)
    private String xpuser;

    @Column(name = "XPCOPR", length = 2, nullable = false)
    private String xpcopr;
}