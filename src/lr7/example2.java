package lr7;

class StringHolder2 {
    private String str;
    public void setFields() {
        this.str = "nothing!";
    }

    public int getLength() {
        return str.length();
    }

    public void setFields(String str) {
        this.str = str;
    }

    public StringHolder2(String str) {
        this.str = str;
    }
}

class SubStringHolder2 extends StringHolder2 {
    public int integer;

    public SubStringHolder2(String str, int integer) {
        super(str);
        this.integer = integer;
    }

    public void setFields() {
        super.setFields();
        this.integer=0;
    }
    public void setFields(String newStr) {
        super.setFields(newStr);
        this.integer=0;
    }
    public void setFields(int newInteger) {
        this.integer=newInteger;
        super.setFields();
    }
    public void setFields(String newStr, int newInteger) {
        super.setFields(newStr);
        this.integer=newInteger;
    }
}

public class example2 {
    public static void main(String[] args) {
        var subHolder = new SubStringHolder2("test", 42);
        System.out.println("lenght: "+subHolder.getLength());
        System.out.println("set str='str'");
        subHolder.setFields("str");
        System.out.println("lenght: "+subHolder.getLength());
        subHolder.setFields("integer: "+subHolder.integer);
        System.out.println("set integer=-1337");
        subHolder.setFields(-1337);
        System.out.println("integer: "+subHolder.integer);
        System.out.println("set integer=123");
        System.out.println("set str='sdf'");
        subHolder.setFields("sdf", 123);
        System.out.println("lenght: "+subHolder.getLength());
        subHolder.setFields("integer: "+subHolder.integer);

    }
}
/*Напишите программу, в которой есть суперкласс с приватным текстовым полем. В
базовом классе должен быть метод для присваивания значения полю: без параметров и с
одним текстовым параметром. Объект суперкласса создается передачей одного текстового
аргумента конструктору. Доступное только для чтения свойство результатом возвращает
длину текстовой строки. На основе суперкласса создается подкласс. В подклассе появляется
дополнительное открытое целочисленное поле. В классе должны быть такие версии метода
для присваивания значений полям (используется переопределение и перегрузка метода из
суперкласса): без параметров, с текстовым параметром, с целочисленным параметром, с
текстовым и целочисленным параметром. У конструктора подкласса два параметра
(целочисленный и текстовый)*/