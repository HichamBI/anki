/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 28/05/16
 * Time: 22:41
 */

package resources;

import card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.GameService;

@RestController
@RequestMapping("anki")
public class GameResource {

    @Autowired
    GameService gameService;

    @RequestMapping("/startGame")
    public Card startGame() {
        return gameService.initGame();
    }

    @RequestMapping(value="/submitEvaluation", method = RequestMethod.POST)
    public Card submitEvaluation(@RequestParam String evaluation) {
        return gameService.submitEvaluation(evaluation);
    }
}
