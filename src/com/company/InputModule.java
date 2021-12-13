package com.company;

import java.util.Map;
import java.util.Scanner;

public class InputModule {

    private final Scanner in;
    private final StringBuilder output;
    private String input;
    private final Database database;

    InputModule(Database database) {
        in = new Scanner(System.in);
        output = new StringBuilder();
        input = "";
        this.database = database;
    }

    public void initInput() {
        System.out.println("Приветствую! Введите числа, соответствующие вашим жалобам (числа разделяйте знаком пробела).\n");
        Map<Integer, String> possibleCompls = database.possibleComplaints;
        Map<Integer, String> complaints = database.complaints;
        printPrompt(possibleCompls);

        while (true) {
            input = in.nextLine();
            String[] complsNumbersString = input.split(" ");
            try {
                for (String keyString : complsNumbersString) {
                    Integer key = Integer.valueOf(keyString);
                    String value = possibleCompls.get(key);
                    if (value != null) {
                        complaints.put(key, possibleCompls.get(key));
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод попробуйте еще раз\n");
                complaints.clear();
                continue;
            }
            break;
        }

        System.out.println("Введите числа, соответствующие результатам вашего осмотра (числа разделяйте знаком пробела).\n");
        Map<Integer, String> possibleExamsResults = database.possibleExamResults;
        Map<Integer, String> examsResults = database.examsResults;
        printPrompt(possibleExamsResults);

        while (true) {
            input = in.nextLine();
            String[] examsResultsNumbersString = input.split(" ");
            try {
                for (String keyString : examsResultsNumbersString) {
                    Integer key = Integer.valueOf(keyString);
                    String value = possibleExamsResults.get(key);
                    if (value != null) {
                        examsResults.put(key, possibleExamsResults.get(key));
                    }
                    else {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод попробуйте еще раз\n");
                examsResults.clear();
                continue;
            }
            break;
        }

        System.out.println("Введите данные вашего анализа крови в порядке и формате, обозначенном ниже (числа разделяйте знаком пробела, в качестве разделителя в десятичных числах используйте точку).\n");
        Map<Integer, String> possibleBloodTestResults = database.possibleBloodTestResults;
        Map<Integer, Double> bloodTestResults = database.bloodTestResults;
        printPrompt(possibleBloodTestResults);

        while (true) {
            input = in.nextLine();
            String[] bloodTestResultsInput = input.split(" ");
            try {
                for (String resultString : bloodTestResultsInput) {
                    Integer key = bloodTestResults.size();
                    Double value = Double.valueOf(resultString);
                    bloodTestResults.put(key, value);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод попробуйте еще раз\n");
                bloodTestResults.clear();
                continue;
            }
            break;
        }
    }

    private void printPrompt(Map<Integer, String> mapToPrint) {
        for (Integer key : mapToPrint.keySet()) {
            output.append(key).append(" - ").append(mapToPrint.get(key)).append("\n");
        }
        System.out.println(output + "\n");
        output.setLength(0);
    }


}
