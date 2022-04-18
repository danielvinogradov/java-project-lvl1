package hexlet.code.games.util.engine;

import org.jetbrains.annotations.NotNull;

/**
 * Пользователь дал неверный ответ.
 */
final class IncorrectUserAnswerException extends Exception {

    IncorrectUserAnswerException(@NotNull String message) {
        super(message);
    }

    IncorrectUserAnswerException() {
        this("Неверный ответ!");
    }

}
