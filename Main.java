package basepackage;

public class Main {

    public static void main(String[] args) {

        int size = 1000000;
        int[] arrayM = new int[size];
        int[] arrayQ = new int[size];
        int[] arrayH = new int[size];

        Sort sort = new Sort();

        Output.csvFile();

        for (int i = 0; i < 10; i++) {
            sort.sortAll(arrayM, arrayQ, arrayH, size);
            System.out.println(i+1);
        }
    }
}