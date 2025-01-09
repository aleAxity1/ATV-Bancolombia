package com.axity.office.commons.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductByUserDTO {
    private Long xpid;
    private String xpuser;
    private String xpcopr;
    private List<String> xpcodo;
}