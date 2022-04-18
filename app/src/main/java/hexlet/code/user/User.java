package hexlet.code.user;

import org.jetbrains.annotations.NotNull;

/**
 * Пользователь / игрок.
 */
public interface User {

    /**
     * Получить имя пользователя. Обычный геттер.
     *
     * @return Имя пользователя.
     */
    String getName();

    /**
     * Установить имя пользователя. Новое имя пользователя не может быть
     * null или иметь нулевую длину.
     *
     * @param s Новое имя пользователя.
     * @throws IllegalArgumentException Если передана пустая строка.
     */
    void setName(@NotNull String s) throws IllegalArgumentException;

    /**
     * Вернет установлено ли имя пользователя. Неустановленным будет считаться
     * как null (никогда не назначенное), так и пустая строка. В имени пользователя
     * должен быть хотя бы один символ.
     *
     * @return Установлено ли имя пользователя.
     */
    boolean isNameSet();

}
