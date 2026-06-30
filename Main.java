public class Main {

    public static void main(String[] args) {

        String text = "Insertion sort typically has a smaller constant factor than merge sort";
        String pattern = "sort";

        BoyerMoore bm = new BoyerMoore();

        bm.search(text, pattern);
    }
}