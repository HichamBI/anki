package game;

import card.Card;
import card.CardEvaluation;
import card.CardsRetriever;
import knowledge.KnowledgeCalculator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Component
public class Game {

    public final static int INITIAL_CARD_KNOWLEDGE = 1;

    private int currentSessionId;
    private Session currentSession;
    private Card currentCard;

    private Map<Integer, Session> sessions;
    private final KnowledgeCalculator knowledgeCalculator;

    public Game() {
        this.currentSessionId = 1;
        this.sessions = new HashMap<>();
        this.knowledgeCalculator = new KnowledgeCalculator();
    }

    public Card init(File cardInput) {
        CardsRetriever cardsRetriever = new CardsRetriever(cardInput);
        LinkedList<Card> allCards = cardsRetriever.getCards();

        currentSession = new Session(allCards);
        currentCard = currentSession.getNextCard();

        sessions.put(currentSessionId, currentSession);

        return currentCard;
    }

    public Card submitEvaluation(CardEvaluation cardEvaluation) {
        updateSessionsMap(cardEvaluation);
        updateCurrentCard();

        return currentCard;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Integer getNextSessionOf(Card card) {
        return 1;
    }

    private void updateCurrentCard() {
        if(!currentSession.isCompleted()) {
            currentCard = currentSession.getNextCard();
        } else {
            currentSessionId++;
            currentSession = sessions.get(currentSessionId);
            currentCard = currentSession.getNextCard();
        }
    }

    private void updateSessionsMap(CardEvaluation cardEvaluation) {
        Integer nextCardSession = currentSessionId + knowledgeCalculator.evaluateCard(currentCard, cardEvaluation) - 1;
        if (sessions.get(nextCardSession) != null)
            sessions.get(nextCardSession).addCard(currentCard);
        else {
            Session newSession = new Session();
            newSession.addCard(currentCard);

            sessions.put(nextCardSession, newSession);
        }
    }
}