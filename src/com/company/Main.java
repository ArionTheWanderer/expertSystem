package com.company;

public class Main {

    public static void main(String[] args) {
        Database database = Database.getInstance();
	    InputModule inputModule = new InputModule(database);
        inputModule.initInput();
        KnowledgeBase knowledgeBase = new KnowledgeBase(database);
        knowledgeBase.determineDiagnosis();
        OutputModule outputModule = new OutputModule(database);
        outputModule.printResults();
    }
}
