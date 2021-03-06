package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.
Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.
Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1
Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length>0){
            String fileName = args[0];
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            Map<String, Double> map = new TreeMap<>();
            while (reader.ready()){
                line = reader.readLine();
                String[] s = line.split(" ");
                //System.out.println(Arrays.toString(s));
                if (map.containsKey(s[0])){
                    Double d = map.get(s[0]);
                    Double sum = d + Double.parseDouble(s[1]);
                    map.put(s[0], sum);
                } else{
                    map.put(s[0], Double.parseDouble(s[1]));
                }

            }
            reader.close();
            //System.out.println(map);
            for (Map.Entry<String, Double> entry: map.entrySet()) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}
