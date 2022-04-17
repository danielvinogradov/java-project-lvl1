package hexlet.code.games.util.engine.gamerounddata;

import java.util.function.Predicate;

public final class DefaultGameRoundData implements GameRoundData {

    private final String title;

    private final String question;

    private final String correctAnswer;

    private final Predicate<String> checker;

    public DefaultGameRoundData(String title, String question, String correctAnswer, Predicate<String> checker) {
        this.title = title;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.checker = checker;
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
