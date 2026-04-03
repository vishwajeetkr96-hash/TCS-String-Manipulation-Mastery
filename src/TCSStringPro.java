import java.util.*;
import java.util.stream.Collectors;

public class TCSStringPro {

    public static void main(String[] args) {
        String input = "Java is amazing";
        String s1 = "listen", s2 = "silent";

        System.out.println("1. Reverse: " + reverseString("Vishwajeet"));
        System.out.println("2. Palindrome (madam): " + isPalindrome("madam"));
        countVowelsConsonants("Bhubaneswar"); // 3
        System.out.println("4. Remove Spaces: " + removeSpaces(" T C S Code "));
        System.out.println("5. Title Case: " + toTitleCase("java spring boot"));
        findDuplicates("programming"); // 6
        System.out.println("7. Is Anagram: " + isAnagram(s1, s2));
        System.out.println("8. Count 'a': " + countOccurrences("banana", 'a'));
        System.out.println("9. First Non-Repeat: " + firstNonRepeated("swiss"));
        System.out.println("10. Reverse Words: " + reverseWords("Java is Fun"));
        System.out.println("11. Only Digits: " + isOnlyDigits("12345"));
        System.out.println("12. Longest Word: " + findLongestWord("I love coding in Java"));
        System.out.println("13. Remove Duplicates: " + removeDuplicates("aabbcc"));
        System.out.println("14. Is Rotation: " + isRotation("ABCD", "CDAB"));
        System.out.println("15. String to Int: " + stringToInt("543"));
        printSubstrings("ABC"); // 16
        System.out.println("17. Pattern Follow (abba): " + followsPattern("dog cat cat dog", "abba"));
        System.out.println("18. Compress: " + compressString("aaabbccccd"));
        System.out.println("19. Longest Palindrome Sub: " + longestPalindromeSubstring("babad"));
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}); // 20
    }

    // 1. Reverse String
    public static String reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) rev += str.charAt(i);
        return rev;
    }

    // 2. Palindrome Check
    public static boolean isPalindrome(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(rev);
    }

    // 3. Count Vowels & Consonants
    public static void countVowelsConsonants(String str) {
        int v = 0, c = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) v++;
            else if (ch >= 'a' && ch <= 'z') c++;
        }
        System.out.println("3. Vowels: " + v + ", Consonants: " + c);
    }

    // 4. Remove White Spaces
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s", "");
    }

    // 5. Title Case
    public static String toTitleCase(String str) {
        return Arrays.stream(str.split(" "))
                .map(w -> Character.toUpperCase(w.charAt(0)) + w.substring(1))
                .collect(Collectors.joining(" "));
    }

    // 6. Find Duplicates
    public static void findDuplicates(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        System.out.print("6. Duplicates: ");
        map.forEach((k, v) -> { if (v > 1) System.out.print(k + " "); });
        System.out.println();
    }

    // 7. Anagram Check
    public static boolean isAnagram(String s1, String s2) {
        char[] a1 = s1.toCharArray(); char[] a2 = s2.toCharArray();
        Arrays.sort(a1); Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    // 8. Count Occurrences
    public static long countOccurrences(String str, char c) {
        return str.chars().filter(ch -> ch == c).count();
    }

    // 9. First Non-Repeated Character
    public static char firstNonRepeated(String str) {
        for (char i : str.toCharArray()) {
            if (str.indexOf(i) == str.lastIndexOf(i)) return i;
        }
        return ' ';
    }

    // 10. Reverse Words
    public static String reverseWords(String str) {
        String[] w = str.split(" ");
        Collections.reverse(Arrays.asList(w));
        return String.join(" ", w);
    }

    // 11. Check Only Digits
    public static boolean isOnlyDigits(String str) {
        return str.matches("\\d+");
    }

    // 12. Find Longest Word
    public static String findLongestWord(String str) {
        return Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).orElse("");
    }

    // 13. Remove Duplicate Chars
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        str.chars().distinct().forEach(c -> sb.append((char) c));
        return sb.toString();
    }

    // 14. Check Rotation
    public static boolean isRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && (s1 + s1).contains(s2);
    }

    // 15. String to Integer
    public static int stringToInt(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) res = res * 10 + (str.charAt(i) - '0');
        return res;
    }

    // 16. All Substrings
    public static void printSubstrings(String str) {
        System.out.print("16. Substrings: ");
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j <= str.length(); j++) System.out.print(str.substring(i, j) + " ");
        System.out.println();
    }

    // 17. Pattern Matcher
    public static boolean followsPattern(String str, String pattern) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) { if (!map.get(c).equals(words[i])) return false; }
            else map.put(c, words[i]);
        }
        return true;
    }

    // 18. String Compression
    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) count++;
            else { sb.append(str.charAt(i)).append(count); count = 1; }
        }
        return sb.toString();
    }

    // 19. Longest Palindrome Substring (Basic)
    public static String longestPalindromeSubstring(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > res.length()) res = sub;
            }
        }
        return res;
    }

    // 20. Group Anagrams
    public static void groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray(); Arrays.sort(ca);
            String key = String.valueOf(ca);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        System.out.println("20. Grouped Anagrams: " + map.values());
    }
}