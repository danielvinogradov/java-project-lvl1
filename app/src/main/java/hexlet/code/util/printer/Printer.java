package hexlet.code.util.printer;

import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс вывода данных.
 * <p>
 * В контексте текущего проекта существует только консольный вывод {@link ConsolePrinter}.
 */
public interface Printer {

    /**
     * Распечатать строку.
     *
     * @param s Строка, которую необходимо распечатать.
     */
    void print(@NotNull String s);

    /**
     * Распечатать строку и добавить перенос строки в конце.
     *
     * @param s Строка, которую необходимо распечатать.
     */
    void println(@NotNull String s);

    /**
     * Распечатать перенос строки.
     */
    void printlb();

    /**
     * Метод, в котором собраны необходимые действия, выполняемые при окончании
     * использования принтера (закрытие потока / подключения и др.).
     */
    void close();

}
