package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATVFFDOM")
@Getter
@Setter
public class Domain {

    @Id
    @Column(name = "XDDOM", length = 2, nullable = false)
    private String xddom;

    @Column(name = "XDNAME", length = 60)
    private String xdname;
}