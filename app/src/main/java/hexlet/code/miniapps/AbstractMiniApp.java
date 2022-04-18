package hexlet.code.miniapps;

import hexlet.code.util.printer.Printer;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * Общая функциональность mini-app.
 */
public abstract class AbstractMiniApp implements Startable {

    /**
     * Ссылка на scanner (ввод), который будет использовать mini-app.
     */
    private final Scanner scanner;

    /**
     * Ссылка на printer (вывод), который будет использовать mini-app.
     */
    private final Printer printer;

    protected AbstractMiniApp(@NotNull Scanner scanner, @NotNull Printer printer) {
        this.scanner = scanner;
        this.printer = printer;
    }

    protected final Scanner getScanner() {
        return scanner;
    }

    protected final Printer getPrinter() {
        return printer;
    }

}
