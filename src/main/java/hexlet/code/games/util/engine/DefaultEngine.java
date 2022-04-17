package hexlet.code.games.util.engine;

import hexlet.code.games.util.engine.gamerounddata.GameRoundData;

import java.util.Scanner;

public final class DefaultEngine implements Engine {

    private final Scanner scanner;

    private final String username;

    private final int rounds;

    private static final int DEFAULT_MAX_ROUNDS = 3;

    public DefaultEngine(Scanner s, String u) {
        this(s, u, DEFAULT_MAX_ROUNDS);
    }

    public DefaultEngine(Scanner s, String u, int r) {
        this.scanner = s;
        this.username = u;
        this.rounds = r;
    }

    @Override
    public void run(Playable game) {

        for (int i = 0; i < rounds; i++) {
            try {
                runRound(game);
            } catch (IncorrectUserAnswerException e) {
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", username);

    }

    private void runRound(Playable game) throws IncorrectUserAnswerException {
        final GameRoundData gameRoundData = game.getGameRoundData();

        System.out.println(gameRoundData.getTitle());
        System.out.printf("Question: %s%n", gameRoundData.getQuestion());
        System.out.print("Answer: ");

        String answer = scanner.next().trim();
        boolean isCorrect = gameRoundData.defineIsCorrect(answer);

        if (isCorrect) {
            System.out.println("Correct");
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n",
                    answer,
                    gameRoundData.getCorrectAnswer());
            System.out.printf("Let's try again, %s!", username);
            throw new IncorrectUserAnswerException();
        }
    }

}
