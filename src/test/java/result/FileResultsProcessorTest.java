package result;

import card.Card;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FileResultsProcessorTest {

    @Test
    public void it_should_process_results() throws Exception {
        URI uri = this.getClass().getClassLoader().getResource("test_results.txt").toURI();
        File file = new File(uri);

        FileResultsProcessor resultsProcessor = new FileResultsProcessor(file);
        resultsProcessor.process();
        Map<Card, Result> resultByCard = resultsProcessor.getResultByCard();

        Card firstCard = new Card("(A) What is the first name of Dicaprio ?", "Leonardo");
        assertThat(resultByCard.get(firstCard).getCurrentKnowledge()).isEqualTo(5);
        assertThat(resultByCard.get(firstCard).getNextSessionId()).isEqualTo(7);

        Card secondCard = new Card("(B) What is the number between one and three ?","Two");
        assertThat(resultByCard.get(secondCard).getCurrentKnowledge()).isEqualTo(3);
        assertThat(resultByCard.get(secondCard).getNextSessionId()).isEqualTo(4);

        Card thirdCard = new Card("(C) What is the fresh translation for 'apple'","Pomme");
        assertThat(resultByCard.get(thirdCard).getCurrentKnowledge()).isEqualTo(4);
        assertThat(resultByCard.get(thirdCard).getNextSessionId()).isEqualTo(5);
    }
}