package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ATVFFACC")
public class Access {

    @Id
    @Column(name = "XAID", nullable = false)
    private int xaid;

    @Column(name = "XANAME", length = 60)
    private String xaname;
}