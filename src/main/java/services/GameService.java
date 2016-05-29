/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 28/05/16
 * Time: 21:52
 */

package services;

import card.Card;
import card.CardEvaluation;
import game.Game;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.FileResultsProcessor;

import java.io.File;

@Service
public class GameService {

    private static final Logger log = Logger.getLogger(FileResultsProcessor.class);

    @Autowired Game game;

    public Card initGame() {
        return game.init(new File("/home/hei/IdeaProjects/anki/src/main/resources/cards.txt"));
    }

    public Card submitEvaluation(String evaluation) {
        return game.submitEvaluation(CardEvaluation.valueOf(evaluation));
    }
}
