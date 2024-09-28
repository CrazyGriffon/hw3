package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     * <p>
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     * <p>
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
    public String findMaxSubstring(String str) {
        //ключ - символ строки, значение - индекс последнего вхождения этого символа
        Map<Character, Integer> map = new HashMap<>();

        //индекс начала максимальной подстроки из уникальных символов
        int startLongest = -1;
        //индекс начала текущей подстроки из уникальных символов
        int start = 0;
        //длина максимальной подстроки из уникальных символов
        int lengthLongest = 0;

        for (int i = 0; i < str.length(); ++i) {
            char c = Character.toLowerCase(str.charAt(i));
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index >= start) {
                    int len = i - start;
                    if (len > lengthLongest) {
                        lengthLongest = len;
                        startLongest = start;
                    }
                    start = index + 1;
                }
            }
            map.put(c, i);
        }

        int len = str.length() - start;
        if (len > lengthLongest) {
            lengthLongest = len;
            startLongest = start;
        }

        return str.substring(startLongest, startLongest + lengthLongest);
    }


    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     * <p>
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     *
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    public boolean check(String sentence) {
        final Map<Character, Integer> map = Stream.iterate('a', x -> (char) (x + 1))
                .limit(26)
                .collect(
                        Collectors.toMap(Function.identity(), x -> 0)
                );

        for (int i = 0; i < sentence.length(); ++i) {
            char c = Character.toLowerCase(sentence.charAt(i));
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Integer value : map.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }

}
