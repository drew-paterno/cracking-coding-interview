package arrays_and_strings;

class Urlify {

    public static void main(String[] args) {
        var result = urlify("Drew is Awesomeeee          ".toCharArray(), 20);
        System.out.println("|" + String.valueOf(result) + "|");
    }

    public static char[] urlify(char[] array, int trueLength) {
        int real = trueLength - 1;
        int i = array.length - 1;
        while(i >= 0) {
            if(i == real) {
                break;
            }
            char c = array[real];
            if(c == ' ') {
                for(char s : "02%".toCharArray()) {
                    array[i] = s;
                    i--;
                }
            } else {
                array[i] = array[real];
                i--;
            }
            real--;
        }
        return array;
    }

}