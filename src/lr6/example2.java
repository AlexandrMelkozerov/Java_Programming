package lr6;

public class example2 {
    public static class Example {
        private static int val1;
        public static void view() {
            System.out.println(val1);
            val1++;
        }
    }
    public static void main(String[] args) {
        Example myex = new Example();
        myex.view();
        myex.view();
        myex.view();
        myex.view();
    }
}


