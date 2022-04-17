package hexlet.code.games.gcd;

/**
 * Вспомогательные функции для GCD.
 */
public final class GCDUtil {

    private GCDUtil() {
    }

    /**
     * Найти наибольший общий делитель двух чисел.
     *
     * @param a Первое число.
     * @param b Второе число.
     * @return Наибольший общий делитель переданных чисел.
     * @see <a href="https://skysmart.ru/articles/mathematic/naibolshij-obshchij-delitel">
     * SkySmart: Наибольший общий делитель (НОД), свойства и формулы</a>
     * @see <a href="https://ru.stackoverflow.com/a/1388866">
     * Stack Overflow: Нахождение наибольшего общего делителя JAVA</a>
     */
    public static int calculateGCD(int a, int b) {
        int count = Math.min(a, b);

        for (int n = count; n >= 1; n--) {
            if (a % n == 0 && b % n == 0) {
                count = n;
                break;
            }
        }

        return count;
    }

}
