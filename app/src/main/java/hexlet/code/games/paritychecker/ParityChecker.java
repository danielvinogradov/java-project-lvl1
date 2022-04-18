package hexlet.code.games.paritychecker;

import hexlet.code.games.AbstractGame;
import hexlet.code.games.util.UserBooleanAnswer;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

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
public final class ParityChecker extends AbstractGame {

    public ParityChecker(@NotNull Random random) {
        super(UserBooleanAnswer.getBooleanAnswerGameTitle(), random);
    }

    @Override
    public GameRoundData getGameRoundData() {
        Random random = getRandom();
        final int randomNumber = random.nextInt();

        final String question = String.valueOf(randomNumber);
        final UserBooleanAnswer correctAnswer = UserBooleanAnswer.fromBoolean(randomNumber % 2 == 0);
        final String correctAnswerString = correctAnswer.getName();

        return new DefaultGameRoundData(question,
                correctAnswerString,
                UserBooleanAnswer.getEqualityPredicate(correctAnswer));
    }

}
