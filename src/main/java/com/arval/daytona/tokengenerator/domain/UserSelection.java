package com.arval.daytona.tokengenerator.domain;

import lombok.Data;

@Data
public class UserSelection {

    private String uuid;
    private String environmentUrl;
    private String authUrl;
    private String module;
    private String country;
    private String jwt;
}
