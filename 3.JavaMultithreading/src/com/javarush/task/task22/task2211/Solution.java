package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            String fileNameRead = args[0];
            String fileNameWrite = args[1];
            Charset Windows1251 = Charset.forName("Windows-1251");
            Charset UTF8 = Charset.forName("UTF-8");
            FileInputStream inputStream = new FileInputStream(fileNameRead);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            for (int i = 0; i < size; i++) {
                buffer[i] = (byte) inputStream.read();
            }
            String s = new String(buffer, Windows1251);
            buffer = s.getBytes(UTF8);
            FileOutputStream outputStream = new FileOutputStream(fileNameWrite);
            outputStream.write(buffer);
        }
    }
}
