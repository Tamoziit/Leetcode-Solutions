import java.util.ArrayList;
import java.util.List;

class EvalRNP {

    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-")
                    && !token.equals("*") && !token.equals("/")) {

                stack.add(Integer.parseInt(token));

            } else {
                int op2 = stack.remove(stack.size() - 1);
                int op1 = stack.remove(stack.size() - 1);

                int res;
                if (token.equals("+")) {
                    res = op1 + op2; 
                }else if (token.equals("-")) {
                    res = op1 - op2; 
                }else if (token.equals("*")) {
                    res = op1 * op2; 
                }else {
                    res = op1 / op2;
                }

                stack.add(res);
            }
        }

        return stack.get(0);
    }

    public static void main(String[] args) {
        EvalRNP ob = new EvalRNP();

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = ob.evalRPN(tokens);
        System.out.println(res);
    }
}
