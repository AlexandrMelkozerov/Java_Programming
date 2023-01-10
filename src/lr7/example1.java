package lr7;
class StringHolder {
    private String str;

    public StringHolder(String str) {
        this.str = str;
    }


    @Override
    public String toString() {
        return "StringHolder{" +
                "str='" + str + '\'' +
                '}';
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

class SubStringHolder extends StringHolder {
    private String str2;

    public SubStringHolder(String str) {
        super(str);
    }

    public SubStringHolder(String str, String str2) {
        super(str);
        this.str2 = str2;
    }

    @Override
    public String toString() {
        return "SubStringHolder{" +
                "str='" + getStr() + "', " +
                "str2='" + str2 + "'" +
                '}';
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}

public class example1 {
    public static void main(String[] args) {
        var holder = new StringHolder("holder");
        System.out.println(holder);
        var subHolder = new SubStringHolder("holder");
        System.out.println(subHolder);
        var subHolder2 = new SubStringHolder("holder", "subholder");
        System.out.println(subHolder2);
    }
}
/*Напишите программу, в которой есть суперкласс с приватным текстовым полем,
конструктором с текстовым параметром и где переопределен метод toString ().
На основе суперкласса путем наследования создается подкласс. У него появляется еще одно
приватное текстовое ноле. Также подкласс должен иметь версии конструктора с одним и
двумя текстовыми аргументами, а еще в нем должен быть переопределен метод toString ().
В обоих классах метод toString () переопределяется так, что он возвращает строку с
названием класса и значение текстового поля или текстовых полей*/