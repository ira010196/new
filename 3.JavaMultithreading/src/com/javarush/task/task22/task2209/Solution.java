package com.javarush.task.task22.task2209;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
/* В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с
первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.
Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн
Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        String word = "";
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
//            word = fileReader.readLine();
//            String[] allWords = word.split(" ");
////            System.out.println(Arrays.toString(allWords));
////            getLine(allWords);
//            StringBuilder result = getLine(allWords);
//            System.out.println(result.toString());
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        //...
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {fileName = reader.readLine();}

        String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        String[] words = content.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());

    }

//    Киев Нью-Йорк Амстердам Вена Мельбурн
    public static StringBuilder getLine(String... words) {
//        List<String> strings = Arrays.asList(words);
//        List <String> result = new ArrayList<>();
//        if (strings.stream().allMatch(String::isNull)){
//            return new StringBuilder();
//        }
//        StringBuilder buildString = new StringBuilder(strings.get(0));
////        System.out.println(buildString);
//        for (int i = 1; i < strings.size(); i++) {
//            result.add(strings.get(i));
//        }
////        System.out.println(result);
//        int wrongWords = 0;
//        while (!result.isEmpty()){
//            char ending = buildString.toString().toUpperCase().charAt(buildString.toString().length()-1);
//            char ending2 = result.get(0).toUpperCase().charAt(result.get(0).length()-1);
////            System.out.println(ending);
////            System.out.println(ending2);
//            if (result.get(0).startsWith(String.valueOf(ending))){
//                buildString.append(" ").append(result.get(0));
////                System.out.println(buildString);
//                result.remove(0);
//            } else if (buildString.toString().startsWith(String.valueOf(ending2))){
//                buildString.insert(0, result.get(0) + " ");
////                System.out.println(buildString);
//                result.remove(0);
//            } else {
//                wrongWords++;
//                result.add(result.get(0));
////                System.out.println(result);
//                result.remove(0);
////                System.out.println(result);
//            }
//
//            if (wrongWords > 1){
//                buildString.append(" ").append(result.get(0));
//                result.remove(0);
//            }
//
//        }
//
////        System.out.println(wrongWords);
//
//        return buildString;

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll(Arrays.asList(words));
        while (wordsList.remove("")){
            wordsList.remove("");
        }
        while (isYes(wordsList)) {
            Collections.shuffle(wordsList);
        }
        for (String word: wordsList){
            result.append(word).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result;

    }

    public static boolean isYes(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i + 1).toLowerCase();
            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
        }
        return false;
    }

}
