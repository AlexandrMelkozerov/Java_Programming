package lr12;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину: ");
        int length = in.nextInt();

        String string = "Напишите функцию, которая принимает на вход список строк и возвращает" +
                " новый список, содержащий только те строки, которые начинаются с большой буквы.";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплитования: " + "\n");

        for(String e : strings){
            System.out.println(e);
        }

        List<String> stringsAfter = filterLengthString(strings, length);

        System.out.println("\n" + "Строка после преобразования: " + "\n");
        for(String e: stringsAfter){
            System.out.println(e);
        }
    }

    public static List<String> filterLengthString(List<String> list, int length){
        return list.stream()
                .filter(s -> s.length() >= length)
                .collect(Collectors.toList());
    }
}
// 7.	Напишите функцию, которая принимает на вход список строк и возвращает новый список, содержащий только те строки, которые имеют длину больше заданного значения.