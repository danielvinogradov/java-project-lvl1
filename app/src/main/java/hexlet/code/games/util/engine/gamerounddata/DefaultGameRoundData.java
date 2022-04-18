package hexlet.code.games.util.engine.gamerounddata;

import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * Дефолтная (и пока что единственная реализация) класса, создающего объект
 * для проведения одного раунда игры.
 * <p>
 * {@link hexlet.code.games.util.engine.Playable}
 */
public final class DefaultGameRoundData implements GameRoundData {

    /**
     * Вопрос.
     */
    private final String question;

    /**
     * Строковое представление правильного ответа (что должен был ввести
     * пользователь, чтобы его ответ был правильным). Не используется
     * для проверки правильности ответа.
     */
    private final String correctAnswer;

    /**
     * Предикат, который проверяет правильность ответа.
     */
    private final Predicate<String> checker;

    public DefaultGameRoundData(String q, String c, Predicate<String> ch) {
        this.question = q;
        this.correctAnswer = c;
        this.checker = ch;
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
    public boolean defineIsCorrect(@NotNull String answer) {
        return checker.test(answer);
    }

}
