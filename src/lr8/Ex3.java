package lr8;
//Создать проект, позволяющий из одного текстового файла,
//содержащего несколько строк (тип String) заранее подготовленного текста
//на русском языке (Пушкин, Лермонтов или другой российсмки классик на
//Ваш вкус), построчно переписать в другой текстовый файл слова
//начинающиеся с согласных букв..
//Требования:
//– слова из предложения выделять методом split();
//– в новом файле следует указать номер строки, в которой иско- мые
//слова находились в исходном файле;
//– для каждой строки указать количество выбранных слов

import java.io.*;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        // Открываем файл для чтения
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("H:\\edu\\t3in.txt"), "UTF-8"));
        // Открываем файл для записи
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("H:\\edu\\t3out.txt"), "UTF-8"));

        String line;
        int lineNumber = 1; // номер текущей строки
        while ((line = reader.readLine()) != null)
        {
            if (line.isEmpty()) continue;

            String[] words = line.split(" "); // разбиваем строку на слова
            int count = 0; // счетчик выбранных слов
            for (String word : words) {
                if (isConsonantWord(word)) { // проверяем, является ли слово начинающимся с согласной буквы
                    writer.write(word + " "); // записываем слово в файл
                    count++;
                }
            }

            // записываем номер строки и количество выбранных слов
            writer.write("(Строка " + lineNumber + ", слово " + count + ")");
            writer.newLine(); // переносим каретку на новую строку
            lineNumber++;
        }

        // закрываем файлы
        reader.close();
        writer.close();
    }

    // метод для проверки, является ли слово начинающимся с согласной буквы

    private static boolean isConsonantWord(String word) {
        // согласные буквы
        String consonants = "бвгджзклмнпрстфхцчшщБВГДЖЗКЛМНПРСТФХЦЧШЩ";
        return consonants.indexOf(word.charAt(0)) != -1;
    }
}