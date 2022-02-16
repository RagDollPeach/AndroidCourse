public class Main {
    /*
     2. Определить сложность следующих алгоритмов:

-. Поиск элемента массива с известным индексом  // O(1)
-. Дублирование одномерного массива через foreach // O(n)
-. Удаление элемента массива с известным индексом без сдвига // O(1)
-. Удаление элемента массива с неизвестным индексом без сдвига // O(n)
-. Удаление элемента массива с неизвестным индексом со сдвига // не знаю как этот сдвиг считается O(n^2)
.

  3. Определить сложность следующих алгоритмов. Сколько произойдет итераций?

a)

        int n = 10000;                                          // O(n*log*n)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                arrayList.add(i * j);
            }                               // как я понимаю 2 вложенных цикла дают n в степени 2, всегда.
        }                                   // не зависимо от того какой используется инкримент
                                            // сам факт двойного цикла дает O(n^2) я прав?
b)

        int n = 10000;                                          // O(n^2)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList.add(i * j);
            }
        }

с)

        int n = 10000;                                          // O(n^2)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                n--;
            }
        }

d*)
```

    factorial(BigInteger.valueOf(10000))

public static BigInteger factorial(BigInteger n) {                  // O(n!)
    if (n.equals(BigInteger.ONE)) {
        return n;
    }
    return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
}


e*)

fib(BigInteger.valueOf(50));                                        // O(n^2)

public static BigInteger fib(BigInteger n) {
    if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO)) {
        return n;
    }
    return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
}
*/
}
