package com.javarush.task.task19.task1923;
import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length==2){
            String fileRead = args[0];
            String fileWrite = args[1];
            BufferedReader reader = new BufferedReader(new FileReader(fileRead));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileWrite));
            while (reader.ready()){
                String line = reader.readLine();
                Pattern pattern = Pattern.compile("\\b\\S*\\d+\\S*\\b");
                Matcher mather = pattern.matcher(line);
                String right = "";
                while (mather.find()){
                    right = line.substring(mather.start(), mather.end());
                    //System.out.println(right);
                    writer.write(right+" ");
                }

            }
            reader.close();
            writer.close();
        }
    }
}
