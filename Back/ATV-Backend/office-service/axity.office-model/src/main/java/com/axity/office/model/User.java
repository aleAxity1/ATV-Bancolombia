package com.axity.office.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "ATVFFUSR")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "XUUSER", length = 10, nullable = false)
    private String xuuser;

    @Column(name = "XUNAME", length = 60)
    private String xuname;

    @Column(name = "XUCARG", length = 6)
    private String xucarg;

    @Column(name = "XUACCE")
    private Short xuacce;

    @Column(name = "XUDOM", length = 2)
    private String xudom;

    @Column(name = "XUUSRT")
    private Short xuusrt;
}