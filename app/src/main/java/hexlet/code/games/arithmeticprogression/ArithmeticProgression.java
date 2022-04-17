package hexlet.code.games.arithmeticprogression;

import hexlet.code.games.util.engine.Playable;
import hexlet.code.games.util.engine.gamerounddata.DefaultGameRoundData;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;

import java.util.Random;
import java.util.function.Predicate;

/**
 * Игра "Арифметическая прогрессия".
 */
public final class ArithmeticProgression implements Playable {

    private static final Random RANDOM = new Random();

    private static final int PROGRESSION_LENGTH = 10;

    private static final String SUBSTITUTE = "..";

    private static final int MAX_STEP = 10;

    private static final int MAX_START_NUM = 100;

    @Override
    public GameRoundData getGameRoundData() {
        final String title = "Please enter the game number and press Enter.";
        final int step = RANDOM.nextInt(MAX_STEP) + 1;
        final int substituteElementIndex = RANDOM.nextInt(PROGRESSION_LENGTH);

        final int firstElValue = RANDOM.nextInt(MAX_START_NUM);
        String[] progression = new String[PROGRESSION_LENGTH];
        for (int i = 0; i < progression.length; i++) {
            progression[i] = String.valueOf(firstElValue + step * i);
        }

        final String correctAnswer = progression[substituteElementIndex];
        progression[substituteElementIndex] = SUBSTITUTE;

        final String question = String.join(" ", progression);

        Predicate<String> predicate = (String answer) -> answer.equals(correctAnswer);

        return new DefaultGameRoundData(title, question, correctAnswer, predicate);
    }
}
