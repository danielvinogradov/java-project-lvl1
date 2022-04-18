package hexlet.code.games.util.engine;

/**
 * Интерфейс движка для запуска игр, имплементирующих {@link Playable}.
 */
public interface Engine {

    /**
     * Запустить игру.
     *
     * @param game Запускаемая игра.
     */
    void run(Playable game);

}
