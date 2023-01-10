package lr7;

class A2 {
    public char chr;

    public A2(char chr) {
        this.chr = chr;
    }

    public A2(A2 a) {
        this.chr = a.chr;
    }

    @Override
    public String toString() {
        return "A2{" +
                "chr=" + chr +
                '}';
    }
}

class B2 extends A2 {
    public String str;

    public B2(char chr, String str) {
        super(chr);
        this.str = str;
    }

    public B2(B2 b) {
        super(b.chr);
        this.str = b.str;
    }

    @Override
    public String toString() {
        return "B2{" +
                "chr=" + chr + ", " +
                "str=" + str +
                '}';
    }
}

class C2 extends B2 {
    public int integer;

    public C2(char chr, String str, int integer) {
        super(chr, str);
        this.integer = integer;
    }

    public C2(C2 c) {
        super(c.chr, c.str);
        this.integer = c.integer;
    }

    @Override
    public String toString() {
        return "C2{" +
                "chr=" + chr + ", " +
                "str=" + str + ", " +
                "integer=" + integer +
                '}';
    }
}

public class example4 {
    public static void main(String[] args) {
        var a2 = new A2('a');
        var b2 = new B2('a', "str");
        var c2 = new C2('a', "str", 42);
        var copyC = new C2(c2);
        System.out.println(a2);
        System.out.println(b2);
        System.out.println(c2);
        System.out.println(copyC);
    }
}
/*Напишите программу, в которой использована цепочка наследования из трех
классов. В первом классе есть открытое символьное поле. Во втором классе появляется
открытое текстовое поле. В третьем классе появляется открытое целочисленное поле. В
каждом из классов должен быть конструктор, позволяющий создавать объект на основе
значений полей, переданных аргументами конструктору, а также конструктор создания копии*/