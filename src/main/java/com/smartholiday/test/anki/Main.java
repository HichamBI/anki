package com.smartholiday.test.anki;

import result.FileResultsProcessor;

import java.io.File;

public final class Main {

    public static void main(String[] args) {
        FileResultsProcessor resultsProcessor = new FileResultsProcessor(new File("src/main/resources/results.txt"));

        resultsProcessor.process();
        resultsProcessor.printResult();
    }
}
