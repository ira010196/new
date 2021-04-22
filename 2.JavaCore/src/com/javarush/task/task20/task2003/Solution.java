package com.javarush.task.task20.task2003;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
Метод main() считывает имя файла с консоли и заполняет runtimeStorage данными из файла.
В методах save() и load() реализуй логику записи в файл и чтения из файла для карты runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле можно игнорировать.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
1. Метод save() должен сохранять runtimeStorage в параметр outputStream.
2. Метод load() должен восстанавливать состояние runtimeStorage из параметра inputStream.
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream,null);
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry<Object, Object> entry: properties.entrySet()) {
            runtimeStorage.put(entry.getKey().toString(), entry.getValue().toString());
        }//напишите тут ваш код

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
