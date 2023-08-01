package com.arval.daytona.tokengenerator.utils;

import com.arval.daytona.tokengenerator.domain.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;

public class ConfigFileReader {

    public Configuration getConfigFromFile() {
        try {
           InputStream stram = ConfigFileReader.class.getResourceAsStream("/datas.json");
           return new ObjectMapper().readValue(stram, Configuration.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
