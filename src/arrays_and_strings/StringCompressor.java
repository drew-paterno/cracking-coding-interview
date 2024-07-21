package arrays_and_strings;

class StringCompressor {
    public static void main(String[] args) {
        var result = compress("aaaaaaaaaaaaaaAaAa");
        System.out.println(result);
    }

    public static String compress(String str) {
        if(str.length() <= 2) {
            return str;
        } else {
            var sb = new StringBuilder();
            int count = 1;
            char curr = str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if(curr == c) {
                    count++;
                } else {
                    sb.append(curr).append(count);
                    count = 1;
                    curr = c;
                }
            }
            sb.append(curr).append(count);
            var compressed = sb.toString();
            return compressed.length() >= str.length() ? str : compressed;
        }

    }
}