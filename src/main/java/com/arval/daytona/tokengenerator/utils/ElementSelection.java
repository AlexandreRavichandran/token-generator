package com.arval.daytona.tokengenerator.utils;

import com.arval.daytona.tokengenerator.domain.Choiceable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.util.Objects.isNull;

public interface ElementSelection<T extends Choiceable> {

    default Choiceable getElementSelection(String name, List<T> choices) {
        Scanner scanner = new Scanner(System.in);
        Long value = null;
        System.out.println("**** " + name.toUpperCase(Locale.ROOT) + " SELECTION ****");
        do{
            choices.forEach(choice -> {
                System.out.println(choice.getId() + " - " + choice.getName());
            });

            System.out.println("Please select the " + name + ": ");

            value = scanner.nextLong();
        } while (Boolean.TRUE.equals(this.checkIfValueIncorrect(value, choices.size())));


        Long finalValue = value;

        return choices.stream().filter(choice -> finalValue.equals(choice.getId())).findAny().orElse(null);
    }


     default Boolean checkIfValueIncorrect(Long value, Integer maxId) {
        Boolean isIncorrect = isNull(value) || value > maxId;

        if(Boolean.TRUE.equals(isIncorrect)) {
            System.out.println("Value incorrect. Please choose again");
        }

        return isIncorrect;
    }
}
