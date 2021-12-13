package com.company;

public class KnowledgeBase {

    private final Database database;

    KnowledgeBase(Database database) {
        this.database = database;
    }

    public void determineDiagnosis() {
        if (database.complaints.containsValue("обильная кровопотеря")) {
            database.explains.add("Пациент жалуется на обильную кровопотерю.");
            if (database.examsResults.size() != 0) {
                database.explains.add("При осмотре выявлены признаки анемии.");
                if (database.bloodTestResults.get(11) >= 1 && database.bloodTestResults.get(10) > 1.7) {
                    // AHA
                    database.explains.add("Цветовой показатель > 1. Ретикулоциты повышены.");
                    database.setDiagnose(Diagnoses.AHA);
                } else {
                    if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                        database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                        database.setDiagnose(Diagnoses.CHA);
                    } else {
                        database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                        database.setDiagnose(Diagnoses.IDN);
                    }
                }
            } else {
                database.explains.add("Осмотр не выявил проблем.");
                if (database.bloodTestResults.get(11) >= 1 && database.bloodTestResults.get(10) >= 1.7) {
                    database.explains.add("Цветовой показатель > 1. Ретикулоциты повышены.");
                    database.setDiagnose(Diagnoses.AHA);
                } else {
                    if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                        database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                        database.setDiagnose(Diagnoses.CHA);
                    } else {
                        database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                        database.setDiagnose(Diagnoses.IDN);
                    }
                }
            }



        } else if (database.complaints.size() != 0) {
            database.explains.add("У пациента присутствуют жалобы на самочувствие");
            if (database.complaints.containsValue("изменения обоняния/вкуса") || database.complaints.containsValue("изменения волос")) {
                database.explains.add("У пациента присутствуют жалобы на изменения обоняния/вкуса или изменения волос");
                if (database.examsResults.size() != 0) {
                    database.explains.add("При осмотре выявлены признаки анемии.");
                    if (database.bloodTestResults.get(10) <= 1.7 && database.bloodTestResults.get(11) < 0.85) {
                        // IDA
                        database.explains.add("Цветовой показатель понижен. Ретикулоциты понижены или в норме.");
                        if (database.bloodTestResults.get(1) < 130 && database.bloodTestResults.get(12) < 37 && database.bloodTestResults.get(0) < 4 && database.bloodTestResults.get(4) >= 10) {
                            database.explains.add("Количество эритроцитов мало, гемоглобин понижен, гематокрит понижен, СОЭ повышен.");
                            database.setDiagnose(Diagnoses.IDA);
                        } else {
                            database.explains.add("Признаков ЖДА в крови не выявлено.");
                            database.setDiagnose(Diagnoses.IDN);
                        }
                    } else if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                        database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                        database.setDiagnose(Diagnoses.CHA);
                    } else {
                        database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                        database.setDiagnose(Diagnoses.IDN);
                    }



                } else {
                    database.explains.add("Осмотр не выявил проблем.");
                    if (database.bloodTestResults.get(10) <= 1.7 && database.bloodTestResults.get(11) < 0.85) {
                        // IDA
                        database.explains.add("Цветовой показатель понижен. Ретикулоциты понижены или в норме.");
                        if (database.bloodTestResults.get(1) < 130 && database.bloodTestResults.get(12) < 37 && database.bloodTestResults.get(0) < 4 && database.bloodTestResults.get(4) >= 10) {
                            database.explains.add("Количество эритроцитов мало, гемоглобин понижен, гематокрит понижен, СОЭ повышен.");
                            database.setDiagnose(Diagnoses.IDA);
                        } else {
                            database.explains.add("Признаков ЖДА в крови не выявлено.");
                            database.setDiagnose(Diagnoses.IDN);
                        }
                    } else if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                        database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                        database.setDiagnose(Diagnoses.CHA);
                    } else {
                        database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                        database.setDiagnose(Diagnoses.IDN);
                    }
                }

            } else {
                if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                    database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                    database.setDiagnose(Diagnoses.CHA);
                } else {
                    database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                    database.setDiagnose(Diagnoses.IDN);
                }
            }

        } else {
            database.explains.add("У пациента отсутствуют жалобы на самочувствие");
            if (database.examsResults.size() != 0) {
                database.explains.add("При осмотре выявлены признаки анемии.");
                database.explains.add("Осмотр не выявил проблем.");
                if (database.bloodTestResults.get(10) <= 1.7 && database.bloodTestResults.get(11) < 0.85) {
                    // IDA
                    database.explains.add("Цветовой показатель понижен. Ретикулоциты понижены или в норме.");
                    if (database.bloodTestResults.get(1) < 130 && database.bloodTestResults.get(12) < 37 && database.bloodTestResults.get(0) < 4 && database.bloodTestResults.get(4) >= 10) {
                        database.explains.add("Количество эритроцитов мало, гемоглобин понижен, гематокрит понижен, СОЭ повышен.");
                        database.setDiagnose(Diagnoses.IDA);
                    } else {
                        database.explains.add("Признаков ЖДА в крови не выявлено.");
                        database.setDiagnose(Diagnoses.IDN);
                    }
                } else if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                    database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                    database.setDiagnose(Diagnoses.CHA);
                } else {
                    database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                    database.setDiagnose(Diagnoses.IDN);
                }


            } else {
                database.explains.add("Осмотр не выявил проблем.");
                if (database.bloodTestResults.get(10) <= 1.7 && database.bloodTestResults.get(11) < 0.85) {
                    // IDA
                    database.explains.add("Цветовой показатель понижен. Ретикулоциты понижены или в норме.");
                    if (database.bloodTestResults.get(1) < 130 && database.bloodTestResults.get(12) < 37 && database.bloodTestResults.get(0) < 4 && database.bloodTestResults.get(4) >= 10) {
                        database.explains.add("Количество эритроцитов мало, гемоглобин понижен, гематокрит понижен, СОЭ повышен.");
                        database.setDiagnose(Diagnoses.IDA);
                    } else {
                        database.explains.add("Признаков ЖДА в крови не выявлено.");
                        database.setDiagnose(Diagnoses.NONE);
                    }
                } else if (database.bloodTestResults.get(10) >= 1.7 && database.bloodTestResults.get(11) < 1) {
                    database.explains.add("Цветовой показатель понижен. Ретикулоциты повышены.");
                    database.setDiagnose(Diagnoses.IDN);
                } else {
                    database.explains.add("Цветовой показатель в норме. Ретикулоциты не повышены.");
                    database.setDiagnose(Diagnoses.NONE);
                }
            }
        }
    }
}
