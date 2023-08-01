package com.arval.daytona.tokengenerator.service;

import com.arval.daytona.tokengenerator.domain.Configuration;
import com.arval.daytona.tokengenerator.domain.UserSelection;
import com.arval.daytona.tokengenerator.utils.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TokenGeneratorService {

    private ConfigFileReader configFileReader = new ConfigFileReader();
    private RequestExecutor requestExecutor = new RequestExecutor();

    public String generateToken() {
       Configuration configuration = this.getConfig();
        UserSelection userSelection = new UserSelection();
        userSelection.setCountry(this.getCountrySelection(configuration));
        userSelection.setEnvironmentUrl(this.getUrlEnvironmentSelection(configuration));
        userSelection.setAuthUrl(this.getAuthEnvironmentSelection(configuration));
        userSelection.setModule(this.getModuleSelection(configuration));
        userSelection.setUuid(configuration.getUuid());

        String formattedUrl = this.requestExecutor.executeRequest(userSelection);
        StringSelection stringSelection = new StringSelection(formattedUrl);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();;
        clipboard.setContents(stringSelection, null);
        System.out.println("Link copied to clipboard");
        return "Program ended";
    }


    private Configuration getConfig() {
        return this.configFileReader.getConfigFromFile();
    }

    private String getCountrySelection(Configuration configuration) {
        CountrySelection countrySelection = new CountrySelection();
        return countrySelection.getElementSelection("country", configuration.getCountries()).getValue();
    }

    private String getAuthEnvironmentSelection(Configuration configuration) {
        AuthEnvironmentSelection environmentSelection = new AuthEnvironmentSelection();
        return environmentSelection.getElementSelection("auth (back) environment", configuration.getAuthEnvironments()).getValue();

    }

    private String getUrlEnvironmentSelection(Configuration configuration) {
        UrlEnvironmentSelection environmentSelection = new UrlEnvironmentSelection();
        return environmentSelection.getElementSelection("url (front) environment", configuration.getUrlEnvironments()).getValue();

    }

    private String getModuleSelection(Configuration configuration) {
        ModuleSelection moduleSelection = new ModuleSelection();
        return moduleSelection.getElementSelection("module", configuration.getModules()).getValue();
    }
}
