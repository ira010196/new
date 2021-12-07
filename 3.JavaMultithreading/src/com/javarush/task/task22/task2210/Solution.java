package com.javarush.task.task22.task2210;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/* 
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример
getTokens("level22.lesson13.task01", ".")
возвращает массив строк
{"level22", "lesson13", "task01"}
1. Метод getTokens должен использовать StringTokenizer.
2. Метод getTokens должен быть публичным.
3. Метод getTokens должен принимать два параметра типа String.
4. Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] array = new String[stringTokenizer.countTokens()];
        List<String> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            list.add(new String(stringTokenizer.nextToken()));
        }
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
