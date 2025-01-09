package com.axity.office.commons.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrequencyDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fxid;
    private String fxcopr;
    private String fxcodo;
    private String fxfrar;
    private Integer fxdifr;
}