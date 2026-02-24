/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Vikram Saluja
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // Lengths of both documents
        int length1 = doc1.length();
        int length2 = doc2.length();

        // Convert to character arrays for comparisons
        char[] chars1 = doc1.toCharArray();
        char[] chars2 = doc2.toCharArray();


         // Table[i][j] represents the length of the longest shared sequence using
         // The first i characters of doc1
         // The first j characters of doc2
        int[][] table = new int[length1 + 1][length2 + 1];

        // Fill the table row by row
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {

                // If characters match, extend the sequence from the diagonal
                if (chars1[i - 1] == chars2[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
                else {
                    // Otherwise take the better result and ignore a character from doc1
                    // Or ignore a character from doc2
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        // The bottom right cell contains the final answer
        return table[length1][length2];
    }
}
