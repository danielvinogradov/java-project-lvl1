package hexlet.code.games;

/**
 * Перечисление всех существующих игр. В текущем приложении значительно пересекается
 * с {@link hexlet.code.cli.gamerunnercliapp.GameRunnerAction}, но это может измениться
 * с добавлением новых cli и увеличением кол-ва mini-apps и games.
 */
public enum Game {

    /**
     * Игра "Проверка на четность".
     * {@link hexlet.code.games.paritychecker.ParityChecker}
     */
    CHECK_PARITY,

    /**
     * Игра "Калькулятор".
     * {@link hexlet.code.games.calculator.Calculator}
     */
    CALCULATOR,

    /**
     * Игра "Наибольший общий делитель (НОД)".
     * {@link hexlet.code.games.gcd.GCD}
     */
    GCD,

    /**
     * Игра "Арифметическая прогрессия".
     * {@link hexlet.code.games.arithmeticprogression.ArithmeticProgression}
     */
    ARITHMETIC_PROGRESSION,

    /**
     * Игра "Простое ли число?".
     * {@link hexlet.code.games.prime.Prime}
     */
    PRIME

}
