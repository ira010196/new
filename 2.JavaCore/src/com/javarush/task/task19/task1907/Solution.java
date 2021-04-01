package com.javarush.task.task19.task1907;
import java.io.*;
import java.util.Arrays;

/*
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        String allChar = "";
        while (fileReader.ready()){
            int data = fileReader.read();
            String s = String.valueOf((char) data);
            allChar += s;
        }
        fileReader.close();
        //System.out.println(allChar);
        //System.out.println(allChar);
        String[] allWords = allChar.split("\\W");
        //System.out.println(Arrays.toString(allWords));
        for (int i = 0; i <allWords.length ; i++) {
            allWords[i] = allWords[i].replaceAll("[^a-zA-Z ]", "");

        }
        //System.out.println(Arrays.toString(allWords));
        int countWorld = 0;
        for (int i = 0; i < allWords.length; i++) {
            if (allWords[i].equals("world")) {
                countWorld++;
            }
        }
        System.out.println(countWorld);


    }
}
