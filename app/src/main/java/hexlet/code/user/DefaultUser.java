package hexlet.code.user;

import org.jetbrains.annotations.NotNull;

/**
 * Дефолтная реализация класса пользователя. Имеет только имя.
 */
public final class DefaultUser implements User {

    /**
     * Имя пользователя.
     */
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(@NotNull String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public boolean isNameSet() {
        return !(name == null || name.isEmpty());
    }

}
