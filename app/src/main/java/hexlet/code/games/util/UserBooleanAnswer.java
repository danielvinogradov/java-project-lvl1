package hexlet.code.games.util;

import java.util.function.Predicate;

public enum UserBooleanAnswer {

    YES(true),

    NO(false);

    private final boolean value;

    UserBooleanAnswer(boolean v) {
        this.value = v;
    }

    public String getName() {
        return this.name();
    }

    public boolean getValue() {
        return value;
    }

    /**
     * Получить элемент перечисления из строки.
     *
     * @param s Строка. Ожидается yes/no. Регистр не имеет значения.
     * @return Элемент перечисления.
     * @throws NullPointerException Элемент не найден.
     */
    public static UserBooleanAnswer fromString(final String s) throws NullPointerException {
        for (UserBooleanAnswer userBooleanAnswer : UserBooleanAnswer.values()) {
            if (userBooleanAnswer.name().equals((s != null ? s : "").toUpperCase())) {
                return userBooleanAnswer;
            }
        }

        throw new NullPointerException();
    }

    /**
     * Получить элемент перечисления по значению (value).
     *
     * @param bool Значение (value), по которому надо найти элемент.
     * @return Элемент перечисления.
     */
    public static UserBooleanAnswer fromBoolean(final boolean bool) {
        for (UserBooleanAnswer userBooleanAnswer : UserBooleanAnswer.values()) {
            if (userBooleanAnswer.value == bool) {
                return userBooleanAnswer;
            }
        }

        // NB! никогда не должно быть исполнено
        return UserBooleanAnswer.NO;
    }

    /**
     * Используется как заголовок игр, где от пользователя ожидается ответ "yes/no". Нужно,
     * чтобы было проще изменить реализацию (например, если вместо "yes" нужно будет вводить "1" и т.д.).
     *
     * @return Заголовок игры с булевым ответом.
     */
    public static String getBooleanAnswerGameTitle() {
        return String.format("Answer '%s' if number is even otherwise answer '%s'.",
                YES.getName(),
                NO.getName());
    }

    /**
     * Предикат для проверки в играх с булевым ответом.
     *
     * @param correctAnswer Правильный ответ.
     * @return Предикат (функция проверки ответа на правильность).
     */
    public static Predicate<String> getEqualityPredicate(UserBooleanAnswer correctAnswer) {
        return (String answer) -> {
            try {
                return UserBooleanAnswer.fromString(answer) == correctAnswer;
            } catch (Exception e) {
                return false;
            }
        };
    }

}
