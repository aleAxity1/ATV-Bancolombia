package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

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