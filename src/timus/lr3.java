package timus;

import java.util.Scanner;

public class lr3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Плановый бюджет:");
        float a = in.nextInt();
        System.out.println("Плановый срок:");
        float b = in.nextInt();
        System.out.println("Время проверки на cегодня:");
        float c = in.nextInt();
        System.out.println("Готовность на сегодня:");
        float d = in.nextInt();
        System.out.println("Расходы на сегодня:");
        float f = in.nextInt();

        float g = lr3.GetEstimation(c, 100f, d);
        float x = lr3.GetOverrun(g, b);
        System.out.println("Задержка срока: " + x +" мес.");

        float k = lr3.GetEstimation(g, f, c);
        float y = lr3.GetOverrun(k, a);
        System.out.println("Перерасход бюджета: " + y +" y.e.");
    }

    static float GetEstimation(float a, float b, float c) {
        return (a*b)/c;
    }

    static float GetOverrun(float a, float b) {
        return a-b;
    }
}
