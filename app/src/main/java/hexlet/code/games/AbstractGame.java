package hexlet.code.games;

import hexlet.code.games.util.engine.Playable;
import hexlet.code.games.util.engine.gamerounddata.GameRoundData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Общая функциональность всех игр.
 */
public abstract class AbstractGame implements Playable {

    /**
     * Заголовок игры. Показывается перед ее началом. Обычно содержит инструкцию к игре и ожидаемый
     * пользовательский ввод.
     */
    private final String title;

    /**
     * Ссылка на инстанс Random. Создается в {@link hexlet.code.cli.gamerunnercliapp.GameRunnerCliApp}
     * единожды, чтобы не создавать несколько инстансов. В настоящий момент используется в каждой игре.
     */
    private final Random random;

    protected AbstractGame(@NotNull String title, @NotNull Random random) {
        this.title = title;
        this.random = random;
    }

    @Override
    public abstract GameRoundData getGameRoundData();

    @Override
    public final String getTitle() {
        return title;
    }

    public final Random getRandom() {
        return random;
    }

}
