import card.Card;
import card.CardsRetriever;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.util.LinkedList;

public class CardsRetrieverTest {

    private CardsRetriever cardsRetriever;

    @Before
    public void setup() throws URISyntaxException {
        File cardsInput = new File(getClass().getResource("cards.txt").toURI());
        cardsRetriever = new CardsRetriever(cardsInput);
    }

    @Test
    public void it_should_retrieve_cards_from_file() {
        LinkedList<Card> cards = cardsRetriever.getCards();

        Assertions.assertThat(cards).extracting("question").containsOnly(
                "Who discovered magnetic field of electric current ?",
                "Headquarters of Amnesty International is at",
                "The first metal used by the man was");
        Assertions.assertThat(cards).extracting("answer").containsOnly("Faraday", "London", "Copper");
    }
}