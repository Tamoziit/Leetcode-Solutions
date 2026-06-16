
public class StringSpecialOps {

    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1); // LIFO delete
                }
            } else if (ch == '#') {
                result.append(result, 0, result.length()); // appending itself
            } else if (ch == '%') {
                result.reverse(); // in-situ reversal
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        StringSpecialOps ob = new StringSpecialOps();

        System.out.println("TEST CASE 1:");
        String input_1 = "a#b%*";
        System.out.println("Input: " + input_1 + "\nOutput: " + ob.processStr(input_1));

        System.out.println("TEST CASE 2:");
        String input_2 = "z*#";
        System.out.println("Input: " + input_2 + "\nOutput: " + ob.processStr(input_2));
    }
}
