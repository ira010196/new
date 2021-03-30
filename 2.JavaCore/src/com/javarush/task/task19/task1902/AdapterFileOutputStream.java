package com.javarush.task.task19.task1902;
import com.javarush.task.task19.task1902.AmigoStringWriter;

import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.Integer.*;

/*
Адаптер
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.
1. AmigoStringWriter должен быть интерфейсом.
2. Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
3. Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
4. Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
6. Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу write() объекта fileOutputStream.
7. Метод close() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
*/
public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) {

    }

    public void flush() throws IOException{
        fileOutputStream.flush();
    }


    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    public void close() throws IOException {
        fileOutputStream.close();

    }


}

