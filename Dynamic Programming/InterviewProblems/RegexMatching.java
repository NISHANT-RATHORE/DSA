package InterviewProblems;

public class RegexMatching {
    public static void main(String[] args) {
        String s = "abbbac";
        String p = ".*a*";
        int m = s.length();
        int n = p.length();
        System.out.println(rec(m - 1, n - 1, s, p));
    }

    private static boolean rec(int i, int j, String s, String p) {
        if (i == -1 && j == -1) return true; // Both strings have been fully matched
        if (i >= 0 && j == -1) return false; // Pattern is exhausted, but text is not
        if (j >= 0 && i == -1) {
            // Check if the remaining pattern can match an empty string
            for (int x = 0; x <= j; x++) {
                if (p.charAt(x) != '*') {
                    return false; // Found a non-* character, cannot match empty string
                }
            }
            return true; // Only * characters left in pattern, can match empty string
        }

        // Ensure we do not access the string out of bounds
        if (i >= 0 && j >= 0) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                return rec(i - 1, j - 1, s, p); // Characters match, move to the next
            } else if (p.charAt(j) == '*') {
                // * can match zero or more of the preceding element
                return rec(i - 1, j, s, p) || rec(i, j - 1, s, p);
            }
        }
        return false; // No match found
}
}
