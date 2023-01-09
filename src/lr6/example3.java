package lr6;

public class example3 {
    private static class Example2{
        //наибольшее значение,
        private static void calcMax(int ... array){
            int max = array[0];
            for (int i =0; i<array.length; i++) {
                max = Math.max(max, array[i]);
            }
            System.out.println("Maximum array[] = "+max);
        }
        //наименьшее значение,
        private static void calcMin(int ... array){
            int min = array[0];
            for (int i =0; i<array.length; i++) {
                min = Math.min(min, array[i]);
            }
            System.out.println("Minimum array[] = "+min);
        }
        //среднее значение из набора чисел.
        private static void calcAvg(int ... array){
            int sum = 0;
            for (int i =0; i<array.length; i++) {
                sum = array[i]+sum;
            }
            double avg = (double)sum/array.length;
            System.out.println("Average array[] = "+avg);
        }
    }
    public static void main(String[] args) {
        Example2.calcMax(1,0,-9,5,25,-101);
        Example2.calcMin(3,0,500,-2,33,-5,6,17);
        Example2.calcAvg(3,0,50,-2,33,-5,6,17);
    }
}