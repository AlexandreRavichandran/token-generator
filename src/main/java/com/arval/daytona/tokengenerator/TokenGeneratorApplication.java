package com.arval.daytona.tokengenerator;

import com.arval.daytona.tokengenerator.domain.Configuration;
import com.arval.daytona.tokengenerator.service.TokenGeneratorService;
import com.arval.daytona.tokengenerator.utils.ConfigFileReader;

public class TokenGeneratorApplication {

    private final ConfigFileReader fileReader = new ConfigFileReader();

    public static void main(String[] args) {
        TokenGeneratorService tokenGeneratorService = new TokenGeneratorService();
        System.out.println(tokenGeneratorService.generateToken());
    }


    public ConfigFileReader getFileReader() {
        return fileReader;
    }
}
