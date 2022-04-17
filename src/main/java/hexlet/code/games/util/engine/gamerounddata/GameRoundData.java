package hexlet.code.games.util.engine.gamerounddata;

public interface GameRoundData {

    String getTitle();

    String getQuestion();

    String getCorrectAnswer();

    boolean defineIsCorrect(String answer);

}
