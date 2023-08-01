package com.arval.daytona.tokengenerator.domain;

import lombok.Data;

@Data
public class Country implements Choiceable {

    private Long id;

    private String name;

    private String value;

}
