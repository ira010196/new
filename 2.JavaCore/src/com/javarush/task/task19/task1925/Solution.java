package com.javarush.task.task19.task1925;
import java.io.*;
import java.util.ArrayList;
/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.
Пример выходных данных в файл2:
длинное,короткое,аббревиатура
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй
FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length!=0 && args.length==2){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            StringBuilder stringBuilder = new StringBuilder();
            //String str = "";
            while (reader.ready()){
                String line = reader.readLine();
                String[] lines = line.split(" ");
                for (String s : lines) {
                    if (s.length()>6){
                        stringBuilder.append(s+",");
                        //str = str + s + ",";

                    }
                }
                //stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                //System.out.println(stringBuilder);
                writer.write(stringBuilder.toString());
                //System.out.println(stringBuilder.toString());
                //writer.write(stringBuilder.toString());
                //writer.write(str.substring(0, str.length()-1));
            }
            reader.close();
            writer.close();
        }

    }
}
