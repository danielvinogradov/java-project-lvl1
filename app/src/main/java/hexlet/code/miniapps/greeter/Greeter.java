package hexlet.code.miniapps.greeter;

import hexlet.code.miniapps.AbstractMiniApp;
import hexlet.code.user.User;
import hexlet.code.util.printer.Printer;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

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
     * Текст сообщения о том, что имя пользователя не должно быть пустым (должно
     * содержать как минимум 1 символ, кроме whitespace).
     */
    private static final String EMPTY_USERNAME_MESSAGE = "Username must contain at least 1 character.";

    /**
     * Ссылка на объект текущего пользователя.
     */
    private final User user;

    public Greeter(@NotNull Scanner scanner, @NotNull Printer printer, @NotNull User user) {
        super(scanner, printer);
        this.user = user;
    }

    @Override
    public void start() {
        Printer printer = getPrinter();
        Scanner scanner = getScanner();

        printer.println(WELCOME_MESSAGE);
        printer.print(String.format("%s ", ASK_NAME_MESSAGE));

        String name = scanner.next().trim();

        while (name.isEmpty()) {
            printer.println(EMPTY_USERNAME_MESSAGE);
            name = scanner.next().trim();
        }

        user.setName(name);
        printer.println(String.format("Hello, %s!", user.getName()));
    }

}
