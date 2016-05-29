/**
 Created by IntelliJ IDEA.
 Author: Hicham B.I.
 Date: 28/05/16
 Time: 08:38
 */

package result;

import card.Card;
import card.CardEvaluation;
import knowledge.KnowledgeCalculator;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;

public class FileResultsProcessor implements Printable {

    private static final Logger log = Logger.getLogger(FileResultsProcessor.class);

    private File evaluationsFile;
    private Map<Card, Result> resultByCard;
    private final KnowledgeCalculator knowledgeCalculator;

    public FileResultsProcessor(File evaluationsFile) {
        this.evaluationsFile = evaluationsFile;
        this.resultByCard = new HashMap<>();
        this.knowledgeCalculator = new KnowledgeCalculator();
    }

    public void process() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(evaluationsFile))) {

            log.info("Start processing ...");
            bufferedReader.lines().forEach((line) -> {
                StringTokenizer tokenizer = new StringTokenizer(line, "|");

                if (tokenizer.hasMoreTokens()) {
                    Integer currentSession = Integer.valueOf(tokenizer.nextToken());
                    String question = tokenizer.nextToken();
                    String answer = tokenizer.nextToken();
                    CardEvaluation evaluation = CardEvaluation.valueOf(tokenizer.nextToken());

                    Card card = new Card(question, answer);
                    int currentEvaluation = knowledgeCalculator.evaluateCard(card, evaluation);
                    Integer nextSessionId = currentSession + currentEvaluation - 1;

                    resultByCard.put(card, new Result(nextSessionId, currentEvaluation));
                }
            });
            log.info("Processing completed...");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Please verify your input file");
        }
    }

    public Map<Card, Result> getResultByCard() {
        return resultByCard;
    }

    @Override
    public void printResult() {
        log.info("Printing results...");

        BiConsumer<Card, Result> resultBiConsumer =
                (card, result) -> System.out.println(
                        card.getQuestion() + "|" + card.getAnswer() + "|"
                                + result.getNextSessionId() + "|" + result.getCurrentKnowledge());

        resultByCard.forEach(resultBiConsumer);
    }
}