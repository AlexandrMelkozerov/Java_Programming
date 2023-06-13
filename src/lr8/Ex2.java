package lr8;

//Создать проект, позволяющий из одного, предварительно
//созданного программными средствами файла, переписать данные,
//соответствующие условию - в исходном файле содержится две строки в
//формате UTF-8 и 5 чисел типа double. В результирующий файл переписать
//вторую строку и положительные числа.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws Exception {
        // Создаем файл
        File file = new File("H:\\edu\\input.txt");
        file.createNewFile();

        // Записываем данные в файл
        try (PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8)) {
            writer.println("String One");
            writer.println("String Two");
            for (int i = 0; i < 5; i++) {
                double min = -2;
                double max = 10;
                double randomNum = Math.random() * (max - min) + min;
                writer.println(randomNum);
            }
        }

        try (Scanner scanner = new Scanner(
                new FileInputStream("H:\\edu\\input.txt"), StandardCharsets.UTF_8)
                .useLocale(Locale.ROOT);
             PrintWriter writer = new PrintWriter(
                     new FileOutputStream("H:\\edu\\output.txt"), true)) {

            // Читаем первую строку
            String firstLine = scanner.nextLine();

            // Читаем вторую строку и записываем ее в результирующий файл
            String secondLine = scanner.nextLine();
            System.out.println("Second line: " + secondLine);
            writer.println(secondLine);

            // Читаем пять чисел и записываем положительные значения в результирующий файл
            for (int i = 0; i < 5; i++) {
                if (scanner.hasNextDouble()) {
                    double num = Double.parseDouble(scanner.next());

                    if (num > 0) {
                        System.out.println("Numb: " + num);
                        writer.println(num);
                    }
                } else {
                    System.out.println("No more tokens");
                    break;
                }
            }
        }
    }
}