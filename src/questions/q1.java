package questions;

public class q1 {

    private static String filterNonInts(String in) {
        return in.replaceAll("[^0-9]", "");
    }

    private static int getCalibrationValue(String in) {
        String nonIntsFiltered = filterNonInts(in);
        int strLen = nonIntsFiltered.length();
        int firstNum = Integer.parseInt(String.valueOf(nonIntsFiltered.charAt(0)));
        int lastNum = Integer.parseInt(String.valueOf(nonIntsFiltered.charAt(strLen - 1)));
        return firstNum * 10 + lastNum;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader("input", "2");

        int sum = 0;
        String line = in.nextLine();
        while (line != null) {
            sum += getCalibrationValue(line);
            line = in.nextLine();
        }
        System.out.println(sum);
    }

}
