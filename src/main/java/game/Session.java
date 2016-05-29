package game;

import card.Card;

import java.util.LinkedList;

public class Session {

    private final LinkedList<Card> cards;

    public Session() {
        this.cards = new LinkedList<>();
    }

    public Session(LinkedList<Card> cards) {
        this.cards = cards;
    }

    public Card getNextCard() {
        return cards.pollFirst();
    }

    public void addCard(Card card) {
        cards.offer(card);
    }

    public boolean isCompleted() {
        return cards.isEmpty();
    }
}
