package lr3;

public class example8 {
    public static void main(String[] args) {
        int size = 10;
        char[] charArray = new char[size];
        char[] arrWord = new char[] {'A', 'E', 'I', 'O', 'U', 'Y'};
        char firstChar = 'A';


        for(int i = 0; i < size; i++)
        {
            boolean flag = true;
            for (char arrGla : arrWord) {
                if (firstChar == arrGla) {
                    i--;
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                charArray[i] = firstChar;
            }
            firstChar++;
        }

        for(int i = 0; i < size; i++){
            System.out.print(charArray[i] + " ");
        }
    }
}
