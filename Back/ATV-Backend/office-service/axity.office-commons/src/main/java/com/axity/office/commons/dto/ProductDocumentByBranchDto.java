package com.axity.office.commons.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDocumentByBranchDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long xsid;
    private Short xscosu;
    private String xscopr;
    private String xscodo;
}