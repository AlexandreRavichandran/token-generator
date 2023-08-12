package com.arval.daytona.tokengenerator.utils;

import com.arval.daytona.tokengenerator.domain.UserSelection;

import java.net.HttpURLConnection;
import java.net.URL;

public class RequestExecutor {

    public String executeRequest(UserSelection userSelection) {

        try {
            String authUrl = userSelection.getAuthUrl()
                    + "/ssoauth?uid="
                    + userSelection.getUuid()
                    + "&db="
                    + userSelection.getCountry();

            URL url = new URL(authUrl);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            userSelection.setJwt(http.getHeaderFields().get("authorization").get(0));

        } catch (Exception e) {

        }

        return this.buildUrl(userSelection);
    }

    private String buildUrl(UserSelection userSelection) {
        return userSelection.getEnvironmentUrl() +
                "/login?db=" +
                userSelection.getCountry() +
                "&module=" +
                userSelection.getModule() +
                "&uid=" +
                userSelection.getUuid() +
                "&jwt=Bearer " +
                userSelection.getJwt();

    }
}
