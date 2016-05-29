import card.Card;
import card.CardEvaluation;
import knowledge.KnowledgeCalculator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KnowledgeCalculatorTest {

    @Test
    public void it_should_return_evaluation_orange_green() throws Exception {
    Card card = new Card("(A) What is the first name of Dicaprio ?", "Leonardo");

        KnowledgeCalculator knowledgeCalculator = new KnowledgeCalculator();
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(4);
    }

    @Test
    public void it_should_return_evaluation_green_green() throws Exception {
        Card card = new Card("(A) What is the first name of Dicaprio ?", "Leonardo");

        KnowledgeCalculator knowledgeCalculator = new KnowledgeCalculator();
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(5);
    }

    @Test
    public void it_should_return_evaluation_orange_orange() throws Exception {
        Card card = new Card("(A) What is the first name of Dicaprio ?", "Leonardo");

        KnowledgeCalculator knowledgeCalculator = new KnowledgeCalculator();
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(3);
    }

    @Test
    public void it_should_return_evaluation_red_orange_green() throws Exception {
        Card card = new Card("(A) What is the first name of Dicaprio ?", "Leonardo");

        KnowledgeCalculator knowledgeCalculator = new KnowledgeCalculator();
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(1);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(4);
    }

    @Test
    public void it_should_return_evaluation_more_operations() throws Exception {
        Card card = new Card("(A) What is the first name of Dicaprio ?", "Leonardo");

        KnowledgeCalculator knowledgeCalculator = new KnowledgeCalculator();
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(3);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.ORANGE)).isEqualTo(5);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(10);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(8);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(7);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(6);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(5);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(4);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(3);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(1);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(1);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.RED)).isEqualTo(1);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(2);
        assertThat(knowledgeCalculator.evaluateCard(card, CardEvaluation.GREEN)).isEqualTo(5);
    }
}