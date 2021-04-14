package com.javarush.task.task19.task1921;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/*
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.
Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.
Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        if (args.length>0){
            String fileName = args[0];
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            //while ((line = reader.readLine()) != null) {
                //String[] word = line.split(" ");
                //System.out.println(Arrays.toString(word));
                //int day = 0;
                //String name = "";
                //String date = "";
                //for (int i = 0; i < word.length; i++) {
                    //try {
                        //day = Integer.parseInt(word[i]);
                        //date = date + " " + day;
                    //} catch (NumberFormatException e){
                        //name += word[i]+" ";
                    //}
                //}
                //SimpleDateFormat format= new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
                //Date birthday = format.parse(date);
                //System.out.println(birthday);
                //PEOPLE.add(new Person(name,birthday));
                //System.out.println(name);
                //System.out.println(date);
            //}
            //reader.close();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            while (reader.ready()) {
                line = reader.readLine();
                String name = line.replaceAll("\\d", "").trim();
                String date = line.replace(name, "").trim();
                PEOPLE.add(new Person(name, sdf.parse(date)));
            }
            reader.close();

        }
        for (Person i: PEOPLE) {
            System.out.println(i.getName() +i.getBirthDate());
        }

    }
}
