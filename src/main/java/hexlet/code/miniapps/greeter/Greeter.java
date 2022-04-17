package hexlet.code.miniapps.greeter;

import hexlet.code.miniapps.AbstractMiniApp;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Приветствует пользователя:
 * <ul>
 *     <li>Показывает приветственное сообщение.</li>
 *     <li>Спрашивает имя пользователя и приветствует его по имени.</li>
 *     <li>Может исполнить callback после получения имени пользователя (callback предается в конструкторе).</li>
 * </ul>
 */
public final class Greeter extends AbstractMiniApp {

    /**
     * Приветственное сообщение.
     */
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";

    /**
     * Текст вопроса об имени пользователя.
     */
    private static final String ASK_NAME_MESSAGE = "May I have your name?";

    /**
     * Callback, который исполнится после того, как будет получено имя пользователя.
     */
    private final Consumer<String> usernameSetCallbackFn;

    /**
     * Конструктор, если коллбэки выполнять нужно.
     *
     * @param username              Имя пользователя.
     * @param scanner               Ссылка на scanner.
     * @param usernameSetCallbackFn Коллбэк, исполняемый после получения имени пользователя.
     */
    public Greeter(@NotNull String username, @NotNull Scanner scanner, Consumer<String> usernameSetCallbackFn) {
        super(username, scanner);
        this.usernameSetCallbackFn = usernameSetCallbackFn;
    }

    /**
     * Конструктор, если коллбэки выполнять НЕ нужно.
     *
     * @param username Имя пользователя.
     * @param scanner  Ссылка на scanner.
     */
    public Greeter(@NotNull String username, @NotNull Scanner scanner) {
        this(username, scanner, null);
    }

    @Override
    public void start() {
        System.out.println(WELCOME_MESSAGE);
        System.out.printf("%s ", ASK_NAME_MESSAGE);
        String name = getScanner().next().trim();

        while (name.isEmpty()) {
            System.out.println("Username must contain at least 1 character.");
            name = getScanner().next().trim();
        }

        System.out.printf("Hello, %s!%n", name);

        if (usernameSetCallbackFn != null) {
            usernameSetCallbackFn.accept(name);
        }
    }

}
