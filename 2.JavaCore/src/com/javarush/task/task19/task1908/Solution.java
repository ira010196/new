package com.javarush.task.task19.task1908;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
Пример тела файла:
12 text var2 14 8ю 1
Результат:
12 14 1
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();
        BufferedReader read = new BufferedReader(new FileReader(fileNameOne));
        BufferedWriter write  = new BufferedWriter(new FileWriter(fileNameTwo));
        String allChar = read.readLine();
        read.close();
        //System.out.println(allChar);
        String[] allWords = allChar.split("\\s");
        //System.out.println(Arrays.toString(allWords));
        for (int i = 0; i <allWords.length ; i++) {
            boolean b = allWords[i].matches("^\\d+$");
            if (b==false){
                allWords[i] = "";
            }
        }
        //System.out.println(Arrays.toString(allWords));
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i <allWords.length ; i++) {
            if (!allWords[i].equals("")){
                numbers.add(allWords[i]);
            }
        }
        //System.out.println(numbers);
        for (String e: numbers) {
            write.write(e+" ");
        }
        write.close();

    }
}
