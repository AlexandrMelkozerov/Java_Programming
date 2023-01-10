package lr7;

class A {
    public int integer;

    public void setFields(int integer) {
        this.integer = integer;
    }

    public A(int integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "A{" +
                "integer=" + integer +
                '}';
    }
}

class B extends A {
    public char chr;

    public void setFields(int newInteger, char newChr) {
        super.setFields(newInteger);
        this.chr = newChr;
    }

    public B(int integer, char chr) {
        super(integer);
        this.chr = chr;
    }

    public String toString() {
        return "B{" +
                "integer=" + integer + ", " +
                "chr=" + chr +
                '}';
    }
}

class C extends B {
    public C(int integer, char chr, String str) {
        super(integer, chr);
        this.str = str;
    }

    public String str;

    public void setFields(int newInteger, char newChr, String newString) {
        super.setFields(newInteger, newChr);
        this.str = newString;
    }

    public String toString() {
        return "C{" +
                "integer=" + integer + ", " +
                "chr=" + chr + ", " +
                "str=" + str +
                '}';
    }

}

public class example3 {
    public static void main(String[] args) {
        var a = new A(1);
        System.out.println(a);
        var b = new B(1, 'a');
        System.out.println(b);
        var c = new C(1, 'a', "str");
        System.out.println(c);
        c.setFields(23, 'r', "notstring");
        System.out.println(c);
    }
}
/*Напишите программу, в которой на основе суперкласса создается подкласс, а на
основе этого подкласса создается еще один подкласс (цепочка наследования из трех
классов). В первом суперклассе есть открытое целочисленное поле, метод с одним
параметром для присваивания значения полю и конструктор с одним параметром.

Во втором классе появляется открытое символьное поле, метод с двумя параметрами для
присваивания значения полям (перегрузка метода из суперкласса) и конструктор с двумя
параметрами.
 В третьем классе появляется открытое текстовое ноле, метод с тремя
аргументами для присваивания значений полям (перегрузка метода из суперкласса) и
конструктор с тремя параметрами. Для каждого класса определите метод toString () так,
чтобы он возвращал строку с названием класса и значениями всех полей объекта*/