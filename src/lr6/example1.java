package lr6;
class Example {
    //есть два поля: символьное и текстовое.
    private char ch;
    private String str;
    //Если метод вызывается с символьным аргументом, то соответствующее значение присваивается символьному полю.

    public void SetField(char c) {
        ch = c;
        System.out.print("\n Вызов метода SetField c аргументом char. ch ="+ch);
    }
    //Если метод вызывается с текстовым аргументом, то он определяет значение текстового ноля.

    public void SetField(String s) {
        str = s;
        System.out.print("\n Вызов метода SetField c аргументом string. str ="+str);
    }
    //Если массив состоит из одного элемента, то он определяет значение символьного поля.
    public void SetField(char [] CharArray) {
        if (CharArray.length == 1){
            ch = CharArray[0];
            System.out.print("\n Вызов метода SetField c массивом char. ch ="+ch);
        }
        else{
            //Если в массиве больше одного элемента) из символов массива формируется текстовая строка и присваивается значением текстовому полю.
            str=new String(CharArray);
            System.out.print("\n Вызов метода SetField c массивом string. str ="+str);}
    }



}

class example_01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Example myex = new Example();
        myex.SetField('A');
        myex.SetField("B");
        char[] CharArray1 = {'п','р','и','в','е','т'};
        char[] CharArray2 = {'C'};
        myex.SetField(CharArray1);
        myex.SetField(CharArray2);

    }
}