package arrays_and_strings;

public class HasOnlyUniqueChars {
    public static void main(String[] args) {
        var result = hasOnlyUniqueChars("abvcd;09876^&*()\\'");
        System.out.println(result);
    }

    public static boolean hasOnlyUniqueChars(String str) {
        int numChars = 256;
        if(str.length() > numChars) {
            return false;
        } else {
            boolean[] map = new boolean[numChars];
            for(char c : str.toCharArray()) {
                if(map[c]) {
                    return false;
                } else {
                    map[c] = true;
                }
            }
            return true;
        }
    }


}