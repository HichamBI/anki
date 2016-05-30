package knowledge;

import card.Card;
import card.CardEvaluation;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeCalculator {

    private final Map<Card, Integer> fibonacciIndexByCard;
    private final Map<Card, Integer> knowledgeByCard;

    public KnowledgeCalculator() {
        this.fibonacciIndexByCard = new HashMap<>();
        this.knowledgeByCard = new HashMap<>();
    }


    public int evaluateCard(Card card, CardEvaluation cardEvaluation) {
        return calculateKnowledge(card, cardEvaluation.getRange());
    }

    private int calculateKnowledge(Card card, int range) {
        Integer currentFibonacciIndex = fibonacciIndexByCard.get(card) != null ? fibonacciIndexByCard.get(card) : 0;
        Integer currentKnowledge = knowledgeByCard.get(card) != null ? knowledgeByCard.get(card) : 1;
        Integer newKnowledge;

        int rangeSign = Integer.signum(range);

        Integer newFibonacciIndex = currentFibonacciIndex + range;

        if (newFibonacciIndex < 0) {
            newFibonacciIndex = 0;
            newKnowledge = currentKnowledge - 1;
        } else {
            newKnowledge = currentKnowledge + rangeSign * FibonacciSequence.getFibonacciOf(newFibonacciIndex);
        }

        if(newKnowledge < 1) {
            newKnowledge = 1;
        }

        fibonacciIndexByCard.put(card, newFibonacciIndex);
        knowledgeByCard.put(card, newKnowledge);

        return newKnowledge;
    }
}
