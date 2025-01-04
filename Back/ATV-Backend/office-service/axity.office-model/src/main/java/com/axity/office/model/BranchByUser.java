package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ATVFFUSS", uniqueConstraints = @UniqueConstraint(columnNames = {"XSUSER", "XSCOSU"}))
@Getter
@Setter
public class BranchByUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "XSID")
    private Long xsid;

    @Column(name = "XSUSER", length = 10, nullable = false)
    private String xsuser;

    @Column(name = "XSCOSU", nullable = false)
    private short xscosu;
}