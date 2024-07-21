package arrays_and_strings;

public class IsPermutationOfPalindrome {
    public static void main(String[] args) {
        var result = isPermutationOfPalindromeBitwise("aaaaAbbcc1213342       ;;;;;ddeegzz");
        System.out.println(result);
    }

    public static boolean isPermutationOfPalindromeBitwise(String str) { // optimal
        int b = 0;
        for(char c : str.toCharArray()) {
            if(Character.isAlphabetic(c)) {
                int index = Character.toLowerCase(c) - 'a';
                b ^= 1 << index;
            }
        }
        return (b & (b - 1)) == 0; // this is the only part I don't really understand.
    }

    public static boolean isPermutationOfPalindrome(String str) { // mine
        var map = buildFrequencyMap(str);
        return checkAtMostOneOdd(map);
    }

    private static int[] buildFrequencyMap(String str) {
        int[] map = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isAlphabetic(c)) {
                var index = Character.toLowerCase(c) - 'a';
                map[index]++;
            }
        }
        return map;
    }

    private static boolean checkAtMostOneOdd(int[] map) {
        boolean odd = false;
        for(int v : map) {
            if(v % 2 == 1 && odd) {
                return false;
            } else if (v % 2 == 1 && !odd) {
                odd = true;
            }
        }
        return true;
    }


}