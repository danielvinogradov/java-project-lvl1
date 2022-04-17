package hexlet.code.games.util;

public enum UserBooleanAnswer {

    YES(true),

    NO(false);

    private final boolean value;

    UserBooleanAnswer(boolean value) {
        this.value = value;
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

}
