package hexlet.code.games.util.engine.gamerounddata;

import java.util.function.Predicate;

public final class DefaultGameRoundData implements GameRoundData {

    private final String title;

    private final String question;

    private final String correctAnswer;

    private final Predicate<String> checker;

    public DefaultGameRoundData(String t, String q, String c, Predicate<String> ch) {
        this.title = t;
        this.question = q;
        this.correctAnswer = c;
        this.checker = ch;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    @Override
    public boolean defineIsCorrect(String answer) {
        return checker.test(answer);
    }

}
