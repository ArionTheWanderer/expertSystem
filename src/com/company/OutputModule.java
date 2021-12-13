package com.company;

public class OutputModule {

    private Database database;

    OutputModule(Database database) {
        this.database = database;
    }

    public void printResults() {
        for (String explain: database.explains) {
            System.out.println(explain + "\n");
        }
        System.out.println("\n");
        switch (database.getDiagnose().ordinal()) {
            case (0) -> System.out.println("Диагноз - " + database.diagnoses.get(0));
            case (1) -> System.out.println("Диагноз - " + database.diagnoses.get(1));
            case (2) -> System.out.println("Диагноз - " + database.diagnoses.get(2));
            case (3) -> System.out.println("Вы здоровы");
            default -> System.out.println("Система не смогла определить вашу проблему");
        }

    }
}
