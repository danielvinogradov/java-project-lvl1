package hexlet.code.miniapps;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * Общая функциональность mini-app.
 */
public abstract class AbstractMiniApp implements Startable {

    /**
     * Имя пользователя. Некоторые mini-app используют его для отображения
     * сообщений.
     */
    private final String username;

    /**
     * Ссылка на scanner, который будут использовать mini-app.
     */
    private final Scanner scanner;

    protected AbstractMiniApp(@NotNull String u, @NotNull Scanner s) {
        this.username = u;
        this.scanner = s;
    }

    protected final String getUsername() {
        return username;
    }

    protected final Scanner getScanner() {
        return scanner;
    }

}
