package hexlet.code.games.util.engine;

import hexlet.code.games.util.engine.gamerounddata.GameRoundData;

/**
 * Общий интерфейс для игр.
 */
public interface Playable {

    /**
     * Возвращает данные для проведения одного раунда игры.
     *
     * @return Данные для одного раунда игры.
     */
    GameRoundData getGameRoundData();

    /**
     * Заголовок игры. Это обычный геттер. Сам заголовок задается в
     * конструкторе {@link hexlet.code.games.AbstractGame}.
     *
     * @return Заголовок игры.
     */
    String getTitle();

}
