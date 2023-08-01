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

            System.out.println(authUrl);
            URL url = new URL(authUrl);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.getHeaderFields();

        } catch (Exception e) {

        }

        return this.buildUrl(userSelection);
    }

    private String buildUrl(UserSelection userSelection) {
        String url =  userSelection.getEnvironmentUrl() +
                "/login?db=" +
                userSelection.getCountry() +
                "&module=" +
                userSelection.getModule() +
                "&uid=" +
                userSelection.getUuid() +
                "&jwt=Bearer " +
                userSelection.getJwt();

        System.out.println(url);

        return url;
    }
}
