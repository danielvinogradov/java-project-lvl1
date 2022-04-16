package hexlet.code.miniapps.paritychecker;

import hexlet.code.cli.util.UserBooleanAnswer;
import hexlet.code.miniapps.AbstractMiniApp;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

/**
 * Реализация игры "Проверка на четность".
 * <p>
 * Правила:
 * <ul>
 *     <li>Пользователю показывается случайное число. И ему нужно ответить, четное это число или нет.</li>
 *     <li>В случае неверного ответа игра завершается.</li>
 *     <li>Любой некорректный ввод считается ошибкой и равносилен неправильному ответу.</li>
 *     <li>Пользователю необходимо ответить на {@link #ROUNDS} вопросов подряд.</li>
 * </ul>
 */
public final class ParityChecker extends AbstractMiniApp {

    private final Random random = new Random();

    /**
     * Количество раундов, которые надо выиграть для победы.
     */
    private static final int ROUNDS = 3;

    public ParityChecker(@NotNull String username, @NotNull Scanner scanner) {
        super(username, scanner);
    }

    /**
     * Сгенерировать случайное целое число.
     *
     * @return Случайное целое число.
     */
    private int generateRandomNumber() {
        return random.nextInt();
    }

    @Override
    public void start() {
        for (int i = 0; i < ROUNDS; i++) {
            // случайное число, для которого будем определять четность
            int randomNumber = generateRandomNumber();

            // правильный ответ (true, если число четное)
            boolean correctAnswer = randomNumber % 2 == 0;

            System.out.printf("Answer '%s' if number is even otherwise answer '%s'.%n",
                    UserBooleanAnswer.YES.getName(),
                    UserBooleanAnswer.NO.getName());
            System.out.printf("Question: %d%n", randomNumber);
            System.out.println("Your answer: ");

            // пользовательский ввод в виде строки
            String userInput = getScanner().next().trim();
            boolean userAnswer;
            try {
                // пытаемся преобразовать пользовательский ввод в boolean
                // регистр не имеет значения (YES, Yes, yes – одинаковые значения)
                userAnswer = UserBooleanAnswer.fromString(userInput).getValue();
            } catch (NullPointerException e) {
                // если не удалось преобразование, то по правилам,
                // любой некорректный ввод считается неправильным ответом
                userAnswer = !correctAnswer;
            }

            if (correctAnswer == userAnswer) {
                System.out.println("Congratulations!");
            } else {
                // если пользователь дал неправильный ответ, то показываем
                // уведомление и завершаем выполнение
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n",
                        userInput,
                        UserBooleanAnswer.fromBoolean(correctAnswer).getName());
                System.out.printf("Let's try again, %s!%n", getUsername());
                return;
            }
        }

        System.out.printf("Congratulations, %s!%n", getUsername());
    }

}
