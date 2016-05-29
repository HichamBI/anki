/**
 Created by IntelliJ IDEA.
 Author: Hicham B.I.
 Date: 28/05/16
 Time: 08:29
 */

package result;

public class Result {

    private Integer nextSessionId;
    private Integer currentKnowledge;

    public Result(Integer nextSessionId, Integer currentKnowledge) {
        this.nextSessionId = nextSessionId;
        this.currentKnowledge = currentKnowledge;
    }

    public Integer getNextSessionId() {
        return nextSessionId;
    }

    public Integer getCurrentKnowledge() {
        return currentKnowledge;
    }

    public void setNextSessionId(Integer sessionId) {
        this.nextSessionId = sessionId;
    }

    public void setCurrentKnowledge(Integer currentKnowledge) {
        this.currentKnowledge = currentKnowledge;
    }
}