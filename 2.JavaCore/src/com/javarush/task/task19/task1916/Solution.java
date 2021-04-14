package com.javarush.task.task19.task1916;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/* 
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!
Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0
Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)
строка1         строка1            SAME строка1
                строка0            ADDED строка0
Пустые строки в примере означают, что этой строки нет в определенном файле.
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/
public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        List<String>fileOne = new ArrayList<>();
        List<String>fileTwo = new ArrayList<>();
        BufferedReader file1Read = new BufferedReader(new FileReader(file1));
        while (file1Read.ready()){
            String lineRead = file1Read.readLine();
            fileOne.add(lineRead);
        }
        file1Read.close();
        //System.out.println(fileOne);
        BufferedReader file2Read = new BufferedReader(new FileReader(file2));
        while (file2Read.ready()){
            String lineRead = file2Read.readLine();
            fileTwo.add(lineRead);
        }
        file2Read.close();
        //System.out.println(fileTwo);
        //for (int j = 0; j <fileOne.size() ; j++) {
            //for (int i = 0; i<fileTwo.size(); i++) {
                //if (fileOne.get(j).equals(fileTwo.get(i))){
                    //lines.add(new LineItem(Type.SAME, fileOne.get(j)));
                    //j++;
                //} else if (fileOne.get(j).equals(fileTwo.get(i+1))){
                    //lines.add(new LineItem(Type.ADDED, fileTwo.get(i)));
                //} else if (!fileOne.get(j).equals(fileTwo.get(i+1))){
                    //lines.add(new LineItem(Type.REMOVED, fileOne.get(j)));
                    //j++;
                    //i--;
                //}
            //}
        //}
            for (int i = 0; i < fileOne.size(); ) {
                for (int j = 0; j < fileTwo.size(); ) {
                    if (fileOne.size()>0) {
                        if (fileOne.get(i).equals(fileTwo.get(j))) {
                            lines.add(new LineItem(Type.SAME, fileOne.get(i)));
                            fileOne.remove(i);
                            fileTwo.remove(j);

                        } else if (fileOne.get(i).equals(fileTwo.get(j + 1))) {
                            lines.add(new LineItem(Type.ADDED, fileTwo.get(j)));
                            fileTwo.remove(j);

                        } else if (!fileOne.get(i).equals(fileTwo.get(j + 1))) {
                            lines.add(new LineItem(Type.REMOVED, fileOne.get(i)));
                            fileOne.remove(i);

                        }
                    } else {
                        break;
                    }
                }
            }
        if (fileOne.size()==1){
            lines.add(new LineItem(Type.REMOVED, fileOne.get(0)));
        }
        if (fileTwo.size()==1){
            lines.add(new LineItem(Type.ADDED, fileTwo.get(0)));
        }

        //for (LineItem i: lines) {
            //System.out.println(i);
        //}
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
