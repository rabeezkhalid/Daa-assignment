public class BoyerMoore {

    private final int ALPHABET_SIZE = 256;

    // Creates the Bad Character Table
    private int[] buildBadCharTable(String pattern) {

        int[] badChar = new int[ALPHABET_SIZE];

        for (int i = 0; i < ALPHABET_SIZE; i++)
            badChar[i] = -1;

        for (int i = 0; i < pattern.length(); i++)
            badChar[(int) pattern.charAt(i)] = i;

        return badChar;
    }

    public void search(String text, String pattern) {

        int[] badChar = buildBadCharTable(pattern);

        int m = pattern.length();
        int n = text.length();

        int shift = 0;

        while (shift <= (n - m)) {

            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j))
                j--;

            if (j < 0) {

                System.out.println("Pattern found at index " + shift);

                if (shift + m < n)
                    shift += m - badChar[text.charAt(shift + m)];
                else
                    shift += 1;

            } else {

                shift += Math.max(1,
                        j - badChar[text.charAt(shift + j)]);
            }
        }
    }
}