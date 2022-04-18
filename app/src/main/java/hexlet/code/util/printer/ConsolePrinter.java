package hexlet.code.util.printer;

import org.jetbrains.annotations.NotNull;

/**
 * Принтер, печатающий все сообщения в консоль (стандартный вывод {@link System#out}).
 */
public final class ConsolePrinter implements Printer {

    @Override
    public void print(@NotNull String s) {
        System.out.print(s);
    }

    @Override
    public void println(@NotNull String s) {
        System.out.println(s);
    }

    @Override
    public void printlb() {
        System.out.println();
    }

    @Override
    public void close() {
        // для консольного принтера закрытие не требуется
    }

}
