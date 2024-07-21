package arrays_and_strings;

public class IsOneEditAway {

    public static void main(String[] args) {
        var result = isOneEditAway("saas", "saaas");
        System.out.println(result);
    }

    public static boolean isOneEditAway(String str1, String str2) {
        if(str1.length() == str2.length()) {
            return isOneReplacementAway(str1, str2);
        } else if (str1.length() + 1 == str2.length()) {
            return isOneInsertAway(str1, str2);
        } else if (str1.length() - 1 == str2.length()) {
            return isOneInsertAway(str2, str1);
        }
        return false;
    }

    private static boolean isOneReplacementAway(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }
        boolean replaced = false;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                if(replaced) {
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }

    private static boolean isOneInsertAway(String str1, String str2) {
        int index1 = 0, index2 = 0;
        while (index2 < str2.length()&& index1 < str1.length()) {
            if(str1.charAt(index1) != str2.charAt(index2)) {
                if(index1 != index2) {
                    return false; // if they're not the same, that means we already inserted once
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

}