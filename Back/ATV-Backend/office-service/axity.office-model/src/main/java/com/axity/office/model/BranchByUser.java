package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ATVFFUSS")
@Getter
@Setter
public class BranchByUser {

    @Id
    @Column(name = "XSUSER", length = 10, nullable = false)
    private String xsuser;

    @Column(name = "XSCOSU", nullable = false)
    private short xscosu;
}