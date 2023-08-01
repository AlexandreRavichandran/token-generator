package com.arval.daytona.tokengenerator.domain;

import lombok.Data;

import java.util.List;

@Data
public class Configuration {

    private String uuid;

    private List<UrlEnvironment> urlEnvironments;

    private List<AuthEnvironment> authEnvironments;

    private List<Module> modules;

    private List<Country> countries;
}
