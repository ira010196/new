package com.javarush.task.task22.task2208;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/*
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}
Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean allValuesAreNull = params.values().stream().allMatch(Objects::isNull);
        if (allValuesAreNull) {
            return "";
        }
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                String result = "%s = '%s' and ";
                String s = String.format(result, entry.getKey(), entry.getValue());
                stringBuilder.append(s);
            }
        }
        stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length());
        return stringBuilder.toString();
    }
}
