import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String input_string = input.nextLine();
        String[] input_array = input_string.split(" ");
        Integer a = Roman.roman.get(input_array[0]);
        boolean roman_first_flag = true;
        if (a == null) {
            a = Integer.parseInt(input_array[0]);
            roman_first_flag = false;
            if (a > 10) {
                throw new Exception("Incorrect input");
            }
        }
        Integer b = Roman.roman.get(input_array[2]);
        boolean roman_second_flag = true;
        if (b == null) {
            b = Integer.parseInt(input_array[2]);
            roman_second_flag = false;
            if (b > 10) {
                throw new Exception("Incorrect input");
            }
        }
        if ((roman_first_flag && !roman_second_flag) || (roman_second_flag && !roman_first_flag)) {
            throw new Exception("Incorrect input");
        }
	    String operand = input_array[1];
        if (!operand.equals("+") && !operand.equals("-") && !operand.equals("*") && !operand.equals("/")) {
            throw new Exception("Incorrect input");
        }
        int result;
        switch (operand) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                result = a / b;
                break;
        }
        if (roman_first_flag) {
           System.out.println(RN.roman(result));
        } else {
            System.out.println(result);
        }
    }
}
