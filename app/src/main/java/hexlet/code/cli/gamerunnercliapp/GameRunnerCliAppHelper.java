package hexlet.code.cli.gamerunnercliapp;

/**
 * Хелпер для game runner. Содержит общие сообщения.
 */
final class GameRunnerCliAppHelper {

    /**
     * Сообщение в начале игры. Краткая инструкция пользователя.
     */
    public static final String START_MESSAGE = "Please enter the game number and press Enter.";

    /**
     * Сообщение идентифицирующее выбор пользовательского действия.
     *
     * Например: "{USER_CHOICE_MESSAGE}: 0 – Exit".
     */
    public static final String USER_CHOICE_MESSAGE = "Your choice";

    /**
     * Сообщение о том, что строка, введенная пользователем, некорректна.
     */
    public static final String WRONG_USER_INPUT_MESSAGE = "Wrong input!";

    /**
     * Сообщение о неизвестной ошибке.
     */
    public static final String UNKNOWN_ERROR_MESSAGE = "Something went wrong!";


    private GameRunnerCliAppHelper() {
    }

}
