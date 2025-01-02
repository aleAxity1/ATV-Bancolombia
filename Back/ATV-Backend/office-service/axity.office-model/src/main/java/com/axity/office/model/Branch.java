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
@Table(name = "XBKNAM")
public class Branch {

    @Id
    @Column(name = "XNNMKY", length = 255)
    private String xnnmky;

    @Column(name = "XNCLCD", length = 255)
    private String xnclcd;

    @Column(name = "XNNAME", length = 255)
    private String xnname;

    @Column(name = "XNADD1", length = 255)
    private String xnadd1;

    @Column(name = "XNADD2", length = 255)
    private String xnadd2;

    @Column(name = "XNCDCT", length = 255)
    private String xncdct;

    @Column(name = "XNCITY", length = 255)
    private String xncity;

    @Column(name = "XNSTTE", length = 255)
    private String xnstte;

    @Column(name = "XNCTRY", length = 255)
    private String xnctry;

    @Column(name = "XNZIP", length = 255)
    private String xnzip;

    @Column(name = "XNNOBP", length = 255)
    private String xnnobp;

    @Column(name = "XNNOAP", length = 255)
    private String xnnoap;

    @Column(name = "XNRTTX", length = 255)
    private String xnrtx;

    @Column(name = "XNTIN", length = 255)
    private String xntin;

    @Column(name = "XNSTIN", length = 255)
    private String xnstin;

    @Column(name = "XNADBR", length = 255)
    private String xnadbr;

    @Column(name = "XNBIÑ", length = 255)
    private String xnbin;

    @Column(name = "XNHBIÑ", length = 255)
    private String xnhbin;

    @Column(name = "XNMBÑ", length = 255)
    private String xnmbn;

    @Column(name = "XNFRST", length = 255)
    private String xnfrst;

    @Column(name = "XNATRN", length = 255)
    private String xnatrn;

    @Column(name = "XNAFRA", length = 255)
    private String xnafra;

    @Column(name = "XNLNCD", length = 255)
    private String xnlncd;

    @Column(name = "XNVAID", length = 255)
    private String xnvaid;

    @Column(name = "XNTAXR", length = 255)
    private String xntaxr;

    @Column(name = "XNTAXN", length = 255)
    private String xntaxn;

    @Column(name = "XNCDON", length = 255)
    private String xncdo;

    @Column(name = "XNDDON", length = 255)
    private String xnddo;

    @Column(name = "XNSDON", length = 255)
    private String xnsdo;

    @Column(name = "XNLNON", length = 255)
    private String xnlno;

    @Column(name = "XNGLON", length = 255)
    private String xnglo;

    @Column(name = "XNIRON", length = 255)
    private String xniro;

    @Column(name = "XNHDPR", length = 255)
    private String xnhdp;

    @Column(name = "XNMCPR", length = 255)
    private String xnmcp;

    @Column(name = "XNMACD", length = 255)
    private String xnmacd;

    @Column(name = "XNCDCI", length = 255)
    private String xncdci;

    @Column(name = "XNCDMR", length = 255)
    private String xncdmr;

    @Column(name = "XNCDST", length = 255)
    private String xncdst;

    @Column(name = "XNCDU1", length = 255)
    private String xncd1;

    @Column(name = "XNCDU2", length = 255)
    private String xncd2;

    @Column(name = "XNCDU3", length = 255)
    private String xncd3;

    @Column(name = "XNENDT", length = 255)
    private String xnend;

    @Column(name = "XNENTM", length = 255)
    private String xnent;

    @Column(name = "XNENUS", length = 255)
    private String xneus;

    @Column(name = "XNENWS", length = 255)
    private String xnews;

    @Column(name = "XNDTLM", length = 255)
    private String xndlm;
}