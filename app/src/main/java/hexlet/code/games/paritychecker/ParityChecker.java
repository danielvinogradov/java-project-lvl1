package hexlet.code.games.paritychecker;

import hexlet.code.games.util.UserBooleanAnswer;
import hexlet.code.games.util.engine.Playable;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Реализация игры "Проверка на четность".
 * <p>
 * Правила:
 * <ul>
 *     <li>Пользователю показывается случайное число. И ему нужно ответить, четное это число или нет.</li>
 *     <li>В случае неверного ответа игра завершается.</li>
 *     <li>Любой некорректный ввод считается ошибкой и равносилен неправильному ответу.</li>
 * </ul>
 */
public final class ParityChecker implements Playable {

    private final Random random = new Random();

    /**
     * Сгенерировать случайное целое число.
     *
     * @return Случайное целое число.
     */
    private int generateRandomNumber() {
        return random.nextInt();
    }

    @Override
    public GameRoundData getGameRoundData() {
        final int randomNumber = generateRandomNumber();
        final UserBooleanAnswer correctAnswer = UserBooleanAnswer.fromBoolean(randomNumber % 2 == 0);

        final String title = String.format("Answer '%s' if number is even otherwise answer '%s'.",
                UserBooleanAnswer.YES.getName(),
                UserBooleanAnswer.NO.getName());
        final String question = String.valueOf(randomNumber);
        final String correctAnswerString = correctAnswer.getName();
        Predicate<String> predicate = (String answer) -> {
            try {
                return UserBooleanAnswer.fromString(answer) == correctAnswer;
            } catch (Exception e) {
                return false;
            }
        };

        return new DefaultGameRoundData(title, question, correctAnswerString, predicate);
    }

}
