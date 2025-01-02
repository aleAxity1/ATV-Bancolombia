package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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