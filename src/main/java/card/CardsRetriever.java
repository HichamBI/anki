package card;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CardsRetriever {

    private static final Logger log = Logger.getLogger(CardsRetriever.class);

    private File cardsSource;

    public CardsRetriever(File cardsSource) {
        this.cardsSource = cardsSource;
    }

    public LinkedList<Card> getCards() {
        LinkedList<Card> retrievedCards = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(cardsSource))) {

            reader.lines().forEach((line) -> {
                StringTokenizer lineTokenizer = new StringTokenizer(line, "|");

                String question = lineTokenizer.nextToken();
                String answer = lineTokenizer.nextToken();

                retrievedCards.add(new Card(question, answer));
            });

        } catch (IOException e) {
            log.error("Cannot retrieve game cards, please verify the path of you input file");
        }

        log.info("Cards retrieving complete");
        return retrievedCards;
    }
}