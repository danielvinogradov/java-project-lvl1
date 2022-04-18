package hexlet.code.games.arithmeticprogression;

import hexlet.code.games.AbstractGame;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Игра "Арифметическая прогрессия".
 * <p>
 * Показываем игроку ряд чисел, образующий арифметическую прогрессию, заменив
 * любое из чисел двумя точками. Игрок должен определить это число.
 */
public final class ArithmeticProgression extends AbstractGame {

    /**
     * Длина прогрессии.
     */
    private static final int PROGRESSION_LENGTH = 10;

    /**
     * Строка, которая заменит в вопросе угадываемое число.
     */
    private static final String SUBSTITUTE = "..";

    /**
     * Минимальный шаг прогрессии.
     */
    public static final int MIN_STEP = 1;

    /**
     * Максимальный шаг прогрессии.
     */
    private static final int MAX_STEP = 10;

    /**
     * Минимальное число, с которого начинается прогрессия.
     */
    private static final int MIN_START_NUM = 10;

    /**
     * Максимальное число, с которого начинается прогрессия.
     */
    private static final int MAX_START_NUM = 100;

    public ArithmeticProgression(@NotNull Random random) {
        super("What number is missing in the progression?", random);
    }

    @Override
    public GameRoundData getGameRoundData() {
        Random random = getRandom();
        // генерируем шаг прогрессии
        final int step = random.nextInt(MAX_STEP - MIN_STEP) + MIN_STEP;

        // случайно генерируем индекс элемента прогрессии, который будем заменять
        final int substituteElementIndex = random.nextInt(PROGRESSION_LENGTH);

        // стартовый элемент прогрессии
        final int firstElValue = random.nextInt(MAX_START_NUM - MIN_START_NUM) + MIN_START_NUM;

        String[] progression = new String[PROGRESSION_LENGTH];
        for (int i = 0; i < progression.length; i++) {
            progression[i] = String.valueOf(firstElValue + step * i);
        }

        // правильный ответ в виде строки
        final String correctAnswer = progression[substituteElementIndex];

        // скрываем выбранные элемент прогрессии
        progression[substituteElementIndex] = SUBSTITUTE;
        // формируем вопрос (строка со скрытым элементом)
        final String question = String.join(" ", progression);

        // функция проверяющая пользовательский ответ на правильность
        Predicate<String> predicate = correctAnswer::equals;

        return new DefaultGameRoundData(question, correctAnswer, predicate);
    }

}
