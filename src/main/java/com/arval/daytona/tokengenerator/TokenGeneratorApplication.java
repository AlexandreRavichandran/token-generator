package com.arval.daytona.tokengenerator;

import com.arval.daytona.tokengenerator.service.TokenGeneratorService;
import com.arval.daytona.tokengenerator.utils.ConfigFileReader;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class TokenGeneratorApplication {

    private final ConfigFileReader fileReader = new ConfigFileReader();
    private static String uuid = "";

    public static void main(String[] args) {
        System.out.println("**** Program started ****");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        if(Boolean.TRUE.equals("".equals(uuid))) {
            System.out.println("Please write you uuid: ");
            uuid = scanner.next();
        } else {
            System.out.println("Please write you uuid [" + uuid +"] :");
            String newUuid = scanner.next();
            if(Boolean.FALSE.equals("".equals(newUuid))) {
                uuid = newUuid;
            }
        }
        TokenGeneratorService tokenGeneratorService = new TokenGeneratorService(uuid);
        String url = tokenGeneratorService.generateToken();
        StringSelection stringSelection = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();;
        clipboard.setContents(stringSelection, null);
        System.out.println("\n");
        System.out.println("*********");
        System.out.println(url);
        System.out.println("Link copied to clipboard");



        System.out.println("*********");
        System.out.println("\n");
        System.out.println("End of program");
        System.out.println("\n");
        System.out.println("Please choose an option");
        System.out.println("1 - Copy again the previous url");
        System.out.println("2 - Restart program");
        Long value = scanner.nextLong();

        while(value.equals(1L)) {
            System.out.println(url);
            System.out.println("Link copied to clipboard");
            clipboard.setContents(stringSelection, null);
            System.out.println("\n");
            System.out.println("**** End of program ****");
            System.out.println("\n");
            System.out.println("Please choose an option");
            System.out.println("1 - Copy again the previous url");
            System.out.println("2 - Restart program");
            value = scanner.nextLong();
        }
        System.out.println("-------------------------");
        TokenGeneratorApplication.main(null);

    }


    public ConfigFileReader getFileReader() {
        return fileReader;
    }
}
