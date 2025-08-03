public class binaryOP {
    public int operation(int left, String op, int right)
    {
        if (op.equalsIgnoreCase("+")) {
            left= left + right;
            return left;
        }
        else if (op.equalsIgnoreCase("-")) {
            left= left - right;
            return left;
        }else if (op.equalsIgnoreCase("*")) {
            left= left * right;
            return left;
        }else if (op.equalsIgnoreCase("/")) {
            left= left / right;
            return left;
        }
        return 0;
    }
}
