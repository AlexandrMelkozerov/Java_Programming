package lr7;

class StringBox {
    protected String str;

    public StringBox(String str) {
        this.str = str;
    }

    public void print() {
        System.out.println("StringBox{str=" + str + '}');
    }
}

class StringBoxA extends StringBox {
    protected int integer;

    public StringBoxA(String str, int integer) {
        super(str);
        this.integer = integer;
    }

    public void print() {
        System.out.println("StringBoxA{str=" + str + ", integer=" + integer + '}');
    }
}

class StringBoxB extends StringBox {
    protected char chr;

    public StringBoxB(String str, char chr) {
        super(str);
        this.chr = chr;
    }

    public void print() {
        System.out.println("StringBoxB{str=" + str + ", chr=" + chr + '}');
    }
}

public class example5 {
    public static void main(String[] args) {
        var box = new StringBox("str");
        box.print();
        var boxA = new StringBoxA("str", 42);
        boxA.print();
        var boxB = new StringBoxB("str", 'a');
        boxB.print();


        StringBox someBox = new StringBoxB("maybe str", '7');
        someBox.print();
    }
}
/*Напишите программу, в которой есть суперкласс с защищенным текстовым полем,
конструктор с текстовым параметром и метод, при вызове которого в консольном окне
отображается название класса и значение поля. На основе суперкласса создаются два
подкласса (оба на основе одного и того же суперкласса).
В одном из классов появляется
защищенное целочисленное поле, там есть конструктор с двумя параметрами и
переопределен метод для отображения значений полей объекта и названия класса.
Во втором подклассе появляется защищенное символьное поле, конструктор с двумя
параметрами и переопределен метод, отображающий в консоли название класса и значения
полей.
 В главном методе создайте объекты каждого из классов. Проверьте работу метода,
отображающего значения полей объектов, для каждого из объектов. Вызовите этот же
метод через объектную переменную суперкласса, которая ссылается на объект производного класса*/