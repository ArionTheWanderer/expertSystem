package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Database {

    private static Database instance;

    public final Map<Integer, String> possibleExamResults = Map.ofEntries(
            entry(0, "тахикардия"),  // ALL
            entry(1, "бледность кожи"), // ALL
            entry(2, "гипотония"),  // AHA, IDA
            entry(3, "гиповолемия"),  // AHA
            entry(4, "гипоксемия") // AHA
    );

    public final Map<Integer, String> possibleComplaints = Map.ofEntries(
            entry(0, "обильная кровопотеря"),  // AHA
            entry(1, "изменения обоняния/вкуса"),  // IDA
            entry(2, "изменения волос"),  // IDA
            entry(3, "снижение аппетита"),  // all
            entry(4, "головокружение"),  // all
            entry(5, "слабость")  // all
    );

    public final Map<Integer, String> possibleBloodTestResults = Map.ofEntries(
            entry(0, "эритроциты (RBC - число (*10^12))"),
            entry(1, "гемоглобин (HGB, Hb - число)"),
            entry(2, "тромбоциты (RLT - число (*10^9))"),
            entry(3, "лейкоциты (WBC - число (*10^9))"),
            entry(4, "СОЭ (%)"),
            entry(5, "гранулоциты (GRA, GRAN - число (*10^9))"),
            entry(6, "моноциты (MON (%))"),
            entry(7, "лимфоциты (LYM, LY% (%))"),
            entry(8, "базофилы (BAS (%))"),
            entry(9, "эонофилы (EOS (%))"),
            entry(10, "ретикулоциты (RTC (%))"),
            entry(11, "цвет. показатель (RDWc (%))"),
            entry(12, "гематокрит (HTC (%)"),
            entry(13, "нейтрофилы палочкоядерные (%)"),
            entry(14, "нейтрофилы сегментоядерные (%)")
    );

    public final Map<Integer,String> diagnoses = Map.ofEntries(
            entry(0, "Железодефицитная анемия"),
            entry(1, "Острая постгеморрагическая анемия"),
            entry(2, "Хроническая постгеморрагическая анемия")
    );

    public final List<String> therapyIDA;
    public final List<String> therapyAHA;
    public final List<String> therapyCHA;

    public final Map<Integer, String> complaints;

    public final Map<Integer, String> examsResults;

    public final Map<Integer, Double> bloodTestResults;

    public final List<String> explains;

    private Diagnoses diagnose;

    private Database() {
        diagnose = Diagnoses.NONE;
        explains = new ArrayList<>();
        complaints = new HashMap<>();
        examsResults = new HashMap<>();
        bloodTestResults = new HashMap<>();
        therapyIDA = new ArrayList<>();
        therapyIDA.add("Найдите причину заболевания.");
        therapyIDA.add("Препараты железа внутрь (2х или 3х валентное железо).");
        therapyIDA.add("Диета с содержанием мясных продуктов.");
        therapyIDA.add("Не следует прибегать к трансфузиям эритроцитов.");
        therapyIDA.add("Показанием для переливания эритроцитов является не уровень гемоглобина , а состояние больного, его гемодинамика.");

        therapyAHA = new ArrayList<>();
        therapyAHA.add("Установите источник кровотечения и немедленно его ликвидацируйте: перевязка и ушивание сосудов, резекция и ушивание поврежденных органов и тканей, повышения свертываемости крови и т. д.");
        therapyAHA.add("Для восстановления ОЦК и снижения степени гемодинамических нарушений по наблюдением трансфузиолога проводится неотложное переливание консервированной крови, кровезаменителей, плазмы и плазмозаменителей. Трансфузии должны выполняться в дозах, превышающих кровопотерю на 20-30%.");

        therapyCHA = new ArrayList<>();
        therapyCHA.add("Установите источник кровотечения и немедленно его ликвидацируйте: перевязка и ушивание сосудов, резекция и ушивание поврежденных органов и тканей, повышения свертываемости крови и т. д.");
        therapyCHA.add("Для восстановления ОЦК и снижения степени гемодинамических нарушений по наблюдением трансфузиолога проводится неотложное переливание консервированной крови, кровезаменителей, плазмы и плазмозаменителей. Трансфузия цельной крови или плазмы показана в небольших гемостатических дозах.");

    }

    public Diagnoses getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnoses diagnose) {
        this.diagnose = diagnose;
    }

    public static Database getInstance() {
        if (Database.instance == null)
            Database.instance = new Database();
        return Database.instance;
    }
}
