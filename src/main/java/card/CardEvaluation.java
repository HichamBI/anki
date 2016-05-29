package card;

public enum CardEvaluation {

    GREEN(2), ORANGE(1), RED(-2) ;

    private int range;

    CardEvaluation(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
