package pl.patri0s.utils;

import java.util.Arrays;

public class Calculate {
    public static double calculate(String input) {
        double result = -1;
        try {
            double[] numbers = Arrays.stream(input.split("[^\\d.]")).mapToDouble(Double::parseDouble).toArray();
            result = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                char mathSign = input.charAt(input.length() - 1);
                if (mathSign == '-') {
                    result -= numbers[i];
                } else if (mathSign == '*') {
                    result *= numbers[i];
                } else if (mathSign == '/') {
                    result /= numbers[i];
                } else {
                    result += numbers[i];
                }
            }
        } catch (Exception e) {
            System.out.println("Wprowadzone dane są nieprawidłowe!");
        }
        return result;
    }
}
